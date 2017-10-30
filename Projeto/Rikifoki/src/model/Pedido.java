package model;

public class Pedido {
	
	private int NumBloco;
	private int ReferenciaPed;
	private String DataVencimento;
	private String Pedidoscol;
	private int QuantProd;
	
	
	public int getNumBloco() {
		return NumBloco;
	}
	public void setNumBloco(int numBloco) {
		NumBloco = numBloco;
	}
	public int getReferenciaPed() {
		return ReferenciaPed;
	}
	public void setReferenciaPed(int referenciaPed) {
		ReferenciaPed = referenciaPed;
	}
	public String getDataVencimento() {
		return DataVencimento;
	}
	public void setDataVencimento(String dataVencimento) {
		DataVencimento = dataVencimento;
	}
	public String getPedidoscol() {
		return Pedidoscol;
	}
	public void setPedidoscol(String pedidoscol) {
		Pedidoscol = pedidoscol;
	}
	public int getQuantProd() {
		return QuantProd;
	}
	public void setQuantProd(int quantProd) {
		QuantProd = quantProd;
	}

}
