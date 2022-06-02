package li1.plp.expressions2.expression;

import li1.plp.expressions1.excecao.Li1Exception;
import li1.plp.expressions1.util.Tipo;
import li1.plp.expressions1.util.TipoPrimitivo;
import li1.plp.expressions2.memory.AmbienteCompilacao;
import li1.plp.expressions2.memory.AmbienteExecucao;
import li1.plp.expressions2.memory.VariavelJaDeclaradaException;
import li1.plp.expressions2.memory.VariavelNaoDeclaradaException;

/**
 * Um objeto desta classe representa uma Expressao de Divisao.
 */
public class ExpDiv extends ExpBinaria {

	/**
	 * Controi uma Expressao de Divisao com as sub-expressoes especificadas.
	 * Assume-se que estas sub-expressoes resultam em <code>ValorInteiro</code> 
	 * quando avaliadas, utilizando arrendondamento.
	 * @param esq Expressao da esquerda
	 * @param dir Expressao da direita
	 */
	public ExpDiv(Expressao esq, Expressao dir) {
		super(esq, dir, "/");
	}

	/**
	 * Retorna o valor da Expressao de Divisao
	 */
	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, 
			VariavelJaDeclaradaException, Li1Exception {
		
		int numerador = ((ValorInteiro) getEsq().avaliar(amb)).valor();
		int denominador = ((ValorInteiro) getDir().avaliar(amb)).valor();
		if(denominador==0){
			throw new Li1Exception(new ValorString("divisaoPorZero"));
		}
		int quociente = Math.round(numerador / denominador);
		return new ValorInteiro(quociente);
	}
	
	/**
	 * Realiza a verificacao de tipos desta expressao.
	 *
	 * @param ambiente o ambiente de compila��o.
	 * @return <code>true</code> se os tipos da expressao sao validos;
	 *          <code>false</code> caso contrario.
	 * @exception VariavelNaoDeclaradaException se existir um identificador
	 *          nao declarado no ambiente.
	 * @exception VariavelNaoDeclaradaException se existir um identificador
	 *          declarado mais de uma vez no mesmo bloco do ambiente.
	 */
	protected boolean checaTipoElementoTerminal(AmbienteCompilacao ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return (getEsq().getTipo(ambiente).eInteiro() && getDir().getTipo(ambiente).eInteiro());
	}

	/**
	 * Retorna os tipos possiveis desta expressao.
	 *
	 * @param ambiente o ambiente de compila��o.
	 * @return os tipos possiveis desta expressao.
	 */
	public Tipo getTipo(AmbienteCompilacao ambiente) {
		return TipoPrimitivo.INTEIRO;
	}
	
	@Override
	public ExpBinaria clone() {
		return new ExpDiv(esq.clone(), dir.clone());
	}
}
