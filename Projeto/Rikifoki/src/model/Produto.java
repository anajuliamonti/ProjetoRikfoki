package model;

public class Produto {
	
	private int Referencia;
	private int Quantidade;
	private double CustoUnit;
	private double PrecoVenda;
	
	
	public int getReferencia() {
		return Referencia;
	}
	public void setReferencia(int referencia) {
		Referencia = referencia;
	}
	public int getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
	public double getCustoUnit() {
		return CustoUnit;
	}
	public void setCustoUnit(double custoUnit) {
		CustoUnit = custoUnit;
	}
	public double getPrecoVenda() {
		return PrecoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		PrecoVenda = precoVenda;
	}
	
}
