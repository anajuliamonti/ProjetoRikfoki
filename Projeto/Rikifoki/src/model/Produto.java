package model;

public class Produto {
	
	private int Referencia;
	private int Quantidade;
	private double CustoUnit;
	private double custoLote;
	private double PrecoVenda;
	private String Descricao; 
	
	public static String[] getAtributes () {
		String[] r = {"Referencia", "Quantidade", "CustoUnit", "CustoLote", "PrecoVendaUnit", "Descricao"};
		return r;
	}
	
	public Object[] getInfo() {
		Object[] r = new Object[6];
		r[0] = Referencia;
		r[1] = Quantidade;
		r[2] = CustoUnit;
		r[3] = custoLote;
		r[4] = PrecoVenda;
		r[5] = Descricao;
		
		return r;
	}
	
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
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public double getCustoLote() {
		return custoLote;
	}
	public void setCustoLote(double custoLote) {
		this.custoLote = custoLote;
	}
}
