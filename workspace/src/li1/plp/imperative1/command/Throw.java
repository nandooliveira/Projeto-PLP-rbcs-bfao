package li1.plp.imperative1.command;

import li1.plp.expressions1.excecao.Li1Exception;
import li1.plp.expressions2.expression.Expressao;
import li1.plp.expressions2.expression.Valor;
import li1.plp.expressions2.memory.VariavelJaDeclaradaException;
import li1.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li1.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li1.plp.imperative1.memory.AmbienteExecucaoImperativa;

public class Throw implements Comando {

	private Expressao expressao;

	public Throw(Expressao expressao) {
		this.expressao = expressao;
	}

	/**
	 * Salva a expressão numa variável especial e levanta a Exception
	 * 
	 * @param ambiente
	 *            o ambiente de execuï¿½ï¿½o.
	 * 
	 * @return o ambiente depois de modificado pela execuï¿½ï¿½o do comando
	 *         <code>throw</code>.
	 * 
	 */
	public AmbienteExecucaoImperativa executar(AmbienteExecucaoImperativa ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, Li1Exception {
		
		Valor valor = expressao.avaliar(ambiente);
		throw new Li1Exception(valor);
	}

	/**
	 * Realiza a verificacao de tipos da expressï¿½o a ser enviada ao
	 * <code>throw</code>
	 * 
	 * @param ambiente
	 *            o ambiente de compilaï¿½ï¿½o.
	 * @return <code>true</code> se a expressï¿½o a ser escrita estï¿½ bem tipada;
	 *         <code>false</code> caso contrario.
	 */
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException {
		return expressao.checaTipo(ambiente);
	}

}
