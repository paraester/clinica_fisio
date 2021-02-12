package Control;

/**
 * Classe Mensagem é responsável por armazenar códigos de erros
 * @author Ester Campos
 * @version 1.0
 * @since Release 01 da aplicação
 */
public class Mensagem {
    private final int erro;

    /**
     * Contrutor da classe Mensagem que irá receber um código de erro
     * @param e referente ao código do erro

    */     
    public Mensagem(int e){

        this.erro = e;  
    }
    /**
     * Método privado responsável por devolver um número inteiro que será referente ao código de erro de uma mensagem.
     * @return inteiro
    */
    private int getErro(){
        return this.erro;
    }
    /**
     * Método privado responsável por devolver um número inteiro que é referente a coordenada x do elemento que está na mensagem.
     * @return inteiro
    */

    /**
     * Método público responsável por devolver o texto relacionado ao código de erro.
     * @return string
    */
    public String getText() {
        int e;
        e = getErro();
        switch( e ) {
            case 0: 
              return "ok";
            case 1:
                return "";                  
            default:
               return "Valores inválidos!";
        }         
    }   
}