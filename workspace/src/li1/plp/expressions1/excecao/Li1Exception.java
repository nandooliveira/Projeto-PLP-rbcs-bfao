package li1.plp.expressions1.excecao;

import li1.plp.expressions2.expression.Valor;

public class Li1Exception extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Valor valor;
	
	public Li1Exception(Valor valor){
		this.valor = valor;
	}
	
	public Valor getValor(){
		return this.valor;
	}
}
