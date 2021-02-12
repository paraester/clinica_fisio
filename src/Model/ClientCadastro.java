package Model;

public class ClientCadastro {

	private int id;
	private String nome = "";
	private int idade = 0;
	private String endereco = "";
	private String datanascimento = "";
	private String sexo = "";
	private String planosaude = "";
	private String telefone = "";
	private String responsavel = "";
	private String especialidade = "";
	private String datainiciotratamento = "";
	private String datadaavaliacao = "";
	private String medicoresponsavel = "";
	private int qtdesessoesrealizadas = 0;
	private String observacaodehoje = "";
	private String medicamento = "";

	public String concatenados() {
		return "Nome [" + nome + "] idade[" + Integer.toString(idade) + "] sexo[" + sexo + "]";

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPlanosaude() {
		return planosaude;
	}

	public void setPlanosaude(String planosaude) {
		this.planosaude = planosaude;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getDatainiciotratamento() {
		return datainiciotratamento;
	}

	public void setDatainiciotratamento(String datainiciotratamento) {
		this.datainiciotratamento = datainiciotratamento;
	}

	public String getDatadaavaliacao() {
		return datadaavaliacao;
	}

	public void setDatadaavaliacao(String datadaavaliacao) {
		this.datadaavaliacao = datadaavaliacao;
	}

	public String getMedicoresponsavel() {
		return medicoresponsavel;
	}

	public void setMedicoresponsavel(String medicoresponsavel) {
		this.medicoresponsavel = medicoresponsavel;
	}

	public int getQtdesessoesrealizadas() {
		return qtdesessoesrealizadas;
	}

	public void setQtdesessoesrealizadas(int qtdesessoesrealizadas) {
		this.qtdesessoesrealizadas = qtdesessoesrealizadas;
	}

	public String getObservacaodehoje() {
		return observacaodehoje;
	}

	public void setObservacaodehoje(String observacaodehoje) {
		this.observacaodehoje = observacaodehoje;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

}
