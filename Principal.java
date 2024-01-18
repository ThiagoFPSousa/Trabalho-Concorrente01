/* ***************************************************************
* Autor............: Thiago Fernandes Pereira de Sousa
* Matricula........: 202210546
* Inicio...........: 25 de agosto de 2023.(25/08/2023)
* Ultima alteracao.: 31 de agosto de 2023.(31/08/2023)
* Nome.............: BRINQUE DE TREM
* Funcao...........: Uma simulacao de trens utilizando ferramentas de uma GUI.
                     Nela o usuario pode escolher as direcoes dos trens(podendo ser os dois superiores ou inferiores ou alternados).
                     Apos a confirmacao, o usuario pode alterar a velocidade de ambos os trens.
                     Existe tambem um botao para resetar a animacao (retornar ao ponto inicial e parados) e um botao para poder mudar as direcoes.
*************************************************************** */

//Importacoes Necessarias.
import controller.EscolhaDirecao;// Importando a classe de controlador EscolhaDirecao, para interagir com a interface.
import java.io.IOException;// Importando a classe IOException, que lida com excecoes de entrada/saida.
import java.net.URL;// Importando a classe URL, que representa uma localizacao uniforme de recurso.
import javafx.application.Application;// Importando a classe base para iniciar a aplicacao JavaFX.
import javafx.fxml.FXMLLoader;// Importando a classe FXMLLoader para carregar arquivos FXML.
import javafx.scene.image.Image;// Importando a classe Image para trabalhar com imagens.
import javafx.scene.Parent;// Importando a classe Parent, que e a raiz da hierarquia de elementos da interface grafica.
import javafx.scene.Scene;// Importando a classe Scene, que representa o conteiner principal para os elementos da interface grafica.
import javafx.stage.Stage;// Importando a classe Stage, que é a janela principal da aplicacao.

public class Principal extends Application {// Declaracao da classe "Principal" que extende a classe "Application".
  
/* ***************************************************************
* Metodo: start
* Funcao: Ponto de entrada da aplicacao JavaFX. Pode lançar uma excecao "IOException".
* Parametros: stage (Do tipo array de "Stage", que representa a janela principal da aplicacao).
* Retorno: nenhum (void).
*************************************************************** */
  @Override // Anotacao "@Override" indica que o metodo a seguir esta sobrescrevendo um metodo da superclasse.
  public void start(Stage stage) throws IOException {
    try {// Inicio de um bloco "try", que e usado para envolver um trecho de codigo onde podem ocorrer excecoes. O codigo dentro deste bloco sera executado, e caso ocorra uma excecao, sera capturada e tratada.
      stage.setTitle("Brinque de Trem");// configurando o titulo da tela.
      stage.setResizable(false);// proibindo o usuario de redimencionar tela.
      Image icon = new Image("/img/icon.png");// carregando uma imagem.
      stage.getIcons().add(icon);// atribuindo um icon na janela.
      URL arquivoFXML = getClass().getResource("/view/TelaInicialController.fxml");// carregando o arquivo fisico.
      Parent root = FXMLLoader.load(arquivoFXML);// carregando estrutura.
      Scene telaInicial = new Scene(root);// criando uma cena.
      stage.setScene(telaInicial);// atribui cena para a janela.
      stage.show();// mostrando janela.
    } // Fim do bloco "try"
    catch (IOException e) { // Bloco "catch" usado para capturar excecoes do tipo "IOException". Se uma excecao desse tipo for lançada no bloco "try", o codigo dentro deste bloco sera executado. A variável "e" contém informacoes sobre a excecao capturada, permitindo tratamento ou registro do erro.
      e.printStackTrace();// O metodo "printStackTrace()" e chamado na variavel de excecao "e". Isso imprimira a pilha de rastreamento da excecao, incluindo detalhes sobre onde a excecao ocorreu. Isso e util para depurar e identificar a origem do erro.
    } // Fim do bloco "catch"
  }// Fim do metodo "start".

/* ***************************************************************
* Metodo: main
* Funcao: Ponto de entrada da aplicacao Java.
* Parametros: args (Do tipo array de "strings", que pode conter argumentos da linha de comando).
* Retorno: nenhum (void).
*************************************************************** */
  public static void main(String[] args) {
    launch(args);// O metodo "launch(args)" e chamado para iniciar a aplicacao JavaFX. Ele inicia a execucao da interface grafica da aplicacao. O parâmetro "args" e passado para a aplicacao como argumentos da linha de comando.
  }// Fim do metodo "main".
}// Fim da classe "Principal".