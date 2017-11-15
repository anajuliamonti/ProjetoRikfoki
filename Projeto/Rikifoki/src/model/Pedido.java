package model;

public class Pedido {
	
	private String ReferenciaPed;
	private String DataVencimento;
	private String Pedidoscol;
	private int QuantProd;
	private String cpf_cliente;
	
	public static String[] getAtributes () {
		String[] r = {"ReferenciaPed", "DataVencimento", "Pedidoscol", "QuantProd"};
		return r;
	}
	
	public Object[] getInfo() {
		Object[] r = new Object[4];
		r[0] = ReferenciaPed;
		r[1] = DataVencimento;
		r[2] = Pedidoscol;
		r[3] = QuantProd;
		
		return r;
	}
	
	public String getCpf_cliente() {
		return cpf_cliente;
	}
	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}
	public String getReferenciaPed() {
		return ReferenciaPed;
	}
	public void setReferenciaPed(String referenciaPed) {
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
