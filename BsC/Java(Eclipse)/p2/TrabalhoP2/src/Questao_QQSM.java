import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Questao_QQSM {
	String nivel;
	String pergunta;
	String respostaA;
	String respostaB;
	String respostaC;
	String respostaD;
	String resposta_certa;
	
	public Questao_QQSM(){
	}
	
	public Questao_QQSM(String level, String question, String opA, String opB, String opC,String opD,String opCerta){
		
		//meter exception
		this.nivel = level;
		this.pergunta = question;
		this.respostaA = opA;
		this.respostaB = opB;
		this.respostaC = opC;
		this.respostaD = opD;
		this.resposta_certa = opCerta;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getRespostaA() {
		return respostaA;
	}

	public void setRespostaA(String respostaA) {
		this.respostaA = respostaA;
	}

	public String getRespostaB() {
		return respostaB;
	}

	public void setRespostaB(String respostaB) {
		this.respostaB = respostaB;
	}

	public String getRespostaC() {
		return respostaC;
	}

	public void setRespostaC(String respostaC) {
		this.respostaC = respostaC;
	}

	public String getRespostaD() {
		return respostaD;
	}

	public void setRespostaD(String respostaD) {
		this.respostaD = respostaD;
	}

	public String getResposta_certa() {
		return resposta_certa;
	}

	public void setResposta_certa(String resposta_certa) {
		this.resposta_certa = resposta_certa;
	}
	
	//write to file
	public String toString(){
		StringBuilder questao = new StringBuilder("\n");
		questao.append(this.nivel);
		questao.append("\n");
		questao.append("P: "+this.pergunta);
		questao.append("\n");
		questao.append("A: "+this.respostaA);
		questao.append("\n");
		questao.append("B: "+this.respostaB);
		questao.append("\n");
		questao.append("C: "+this.respostaC);
		questao.append("\n");
		questao.append("D: "+this.respostaD);
		questao.append("\n");
		questao.append("R: "+this.resposta_certa);
		questao.append("\n");
		return questao.toString();
	}
	
	public void add_para_ficheiro() throws IOException{
		try{
		QQSM ficheiro = new QQSM();
		
		FileWriter fw = new FileWriter(ficheiro.getPath(),true);	
		BufferedWriter bw = new BufferedWriter(fw);
		bw.append(toString());
		bw.close();
			
		}catch (IOException e ){
		e.printStackTrace();
		}
	}
	

}
	//so falta colocar dentro do ficheiro

