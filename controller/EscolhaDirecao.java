/* ***************************************************************
* Autor............: Thiago Fernandes Pereira de Sousa
* Matricula........: 202210546
* Inicio...........: 25 de agosto de 2023.(25/08/2023)
* Ultima alteracao.: 31 de agosto de 2023.(31/08/2023)
* Nome.............: BRINQUE DE TREM
* Funcao...........: Uma simulacao de trens utilizando ferramentas de uma GUI.
					 Nela o usuario pode escolher as direcoes dos trens(podendo ser os dois superiores ou inferiores ou alternados).
					 Apos a confirmacao, o usuario pode alterar a velocidade de ambos os trens.
					 Existe tambem um botao para resetar a animacao (retornar ao ponto inicial e parados).
*************************************************************** */

package controller;// Declaracao do pacote 'controller' ao qual pertence a classe 'EscolhaDirecao'.

//Importacoes Necessarias.
import java.io.IOException;// Importacao necessaria para lidar com excecoes de entrada/saida (IO).
import java.net.URL;// Importacao necessaria para trabalhar com URLs, que podem ser uteis para carregar recursos ou interagir com a internet.
import java.util.ResourceBundle;// Importacao necessaria para trabalhar com pacotes de recursos (resource bundles), que sao usados para internacionalizar aplicativos.
import javafx.animation.PathTransition;// Importacao para a classe 'PathTransition' do JavaFX, que e usada para criar animações que movem nos ao longo de um caminho especificado.
import javafx.event.ActionEvent;// Importacao para a classe 'ActionEvent' do JavaFX, usada para lidar com eventos de açao, como cliques de botao.
import javafx.fxml.FXML;// Importacao para a anotacao 'FXML', usada para injetar elementos do arquivo FXML no codigo Java.
import javafx.fxml.Initializable;// Importacao para a interface 'Initializable', que requer a implementação de um metodo 'initialize'.
import javafx.scene.control.Button;// Importacao para a classe 'Button' do JavaFX, usada para criar botoes clicaveis.
import javafx.scene.control.RadioButton;// Importacao para a classe 'RadioButton' do JavaFX, usada para criar botaes de opcao.
import javafx.scene.control.ToggleGroup;// Importacao para a classe 'ToggleGroup' do JavaFX, usada para agrupar botoes de opcao, de modo que apenas um deles possa ser selecionado de cada vez.
import javafx.scene.control.Label;// Importacao para a classe 'Label' do JavaFX, usada para exibir texto ou rotulos em uma interface grafica.
import javafx.scene.image.ImageView;// Importacao para a classe 'ImageView' do JavaFX, usada para exibir imagens em uma interface grafica.
import javafx.scene.layout.AnchorPane;// Importacao para a classe 'AnchorPane' do JavaFX, que e um layout que permite ancorar elementos de interface em relacao a bordas ou outros elementos.
import javafx.scene.shape.LineTo;// Importacao para a classe 'LineTo' do JavaFX, usada para desenhar uma linha em um objeto 'Path'.
import javafx.scene.shape.MoveTo;// Importacao para a classe 'MoveTo' do JavaFX, usada para mover o ponto de inicio em um objeto 'Path'.
import javafx.scene.shape.Path;// Importacao para a classe 'Path' do JavaFX, usada para definir um caminho para animacoes ou desenhos.
import javafx.util.Duration;// Importacao para a classe 'Duration' do JavaFX, usada para especificar a duracao de animacoes.

public class EscolhaDirecao implements Initializable {// Declaracao da classe "EscolhaDirecao" que implementa o metodo "initialize".
  // Declaracao dos elementos da interface grafica mapeados a partir do arquivo FXML.
  
  // Paineis (AnchorPane). 
  @FXML// Marcador FXML.
  private AnchorPane anchorPaneDirecao;// Escolha de Direcoes.
  @FXML// Marcador FXML.
  private AnchorPane anchorPanePrincipal;// Tela Principal.
  @FXML// Marcador FXML.
  private AnchorPane anchorPaneStatusTrens;// Status das velocidades dos trens.
  @FXML// Marcador FXML.
  private AnchorPane anchorPaneVelocidade;// Escolha das Velocidades dos trens.

  // Imagens.
  @FXML// Marcador FXML.
  private ImageView background;// Background Principal.
  @FXML// Marcador FXML.
  private ImageView backgroundDirecao;// Background da escolha de Direcoes.
  @FXML// Marcador FXML.
  private ImageView trem1;// Trem 1.
  @FXML// Marcador FXML.
  private ImageView trem2;// Trem 2.
  @FXML// Marcador FXML.
  private ImageView trilho;// Trilho.

  // Rotulos (Labels)
  @FXML// Marcador FXML.
  private Label brinqueDeTrem;// Rotulo principal com nome do programa.
  @FXML// Marcador FXML.
  private Label direcaoDePartida;// Rotulo da direcao de partida.
  @FXML// Marcador FXML.
  private Label status0Trem1;// Rotulo do status de 0Km/h do trem 1.
  @FXML// Marcador FXML.
  private Label status25Trem1;// Rotulo do status de 25Km/h do trem 1.
  @FXML// Marcador FXML.
  private Label status50Trem1;// Rotulo do status de 50Km/h do trem 1.
  @FXML// Marcador FXML.
  private Label status75Trem1;// Rotulo do status de 75Km/h do trem 1.
  @FXML// Marcador FXML.
  private Label status100Trem1;// Rotulo do status de 100Km/h do trem 1.
  @FXML// Marcador FXML.
  private Label status0Trem2;// Rotulo do status de 0Km/h do trem 2.
  @FXML// Marcador FXML.
  private Label status25Trem2;// Rotulo do status de 25Km/h do trem 2.
  @FXML// Marcador FXML.
  private Label status50Trem2;// Rotulo do status de 50Km/h do trem 2.
  @FXML// Marcador FXML.
  private Label status75Trem2;// Rotulo do status de 75Km/h do trem 2.
  @FXML// Marcador FXML.
  private Label status100Trem2;// Rotulo do status de 100Km/h do trem 2.
  @FXML// Marcador FXML.
  private Label velocidadeTrem1;// Rotulo de velocidade do trem 1.
  @FXML// Marcador FXML.
  private Label velocidadeTrem2;// Rotulo de velocidade do trem 2.

  // Grupos de alternancia (ToggleGroups) para os botoes de selecao.
  @FXML// Marcador FXML.
  private ToggleGroup toggleGroup;// Alternancia dos botoes de selecao de direcao.
  @FXML// Marcador FXML.
  private ToggleGroup toggleGroupv1;// Alternancia dos botoes de selecao de velocidade do trem 1.
  @FXML// Marcador FXML.
  private ToggleGroup toggleGroupv2;// Alternancia dos botoes de selecao de velocidade do trem 2.

  // Botões de selecao.
  @FXML// Marcador FXML.
  private RadioButton btnAlternadoI;// Para Alternado I.
  @FXML// Marcador FXML.
  private RadioButton btnAlternadoII;// Para Alternado II.
  @FXML// Marcador FXML.
  private RadioButton btnInferior;// Para Inferior.
  @FXML// Marcador FXML.
  private RadioButton btnSuperior;// Para Superior.
  @FXML// Marcador FXML.
  private RadioButton t1Velocidade0;// Para Velocidade 0 do trem 1.
  @FXML// Marcador FXML.
  private RadioButton t1Velocidade25;// Para Velocidade 25 do trem 1.
  @FXML// Marcador FXML.
  private RadioButton t1Velocidade50;// Para Velocidade 50 do trem 1.
  @FXML// Marcador FXML.
  private RadioButton t1Velocidade75;// Para Velocidade 75 do trem 1.
  @FXML// Marcador FXML.
  private RadioButton t1Velocidade100;// Para Velocidade 100 do trem 1.
  @FXML// Marcador FXML.
  private RadioButton t2Velocidade0;// Para Velocidade 0 do trem 2.
  @FXML// Marcador FXML.
  private RadioButton t2Velocidade25;// Para Velocidade 25 do trem 2.
  @FXML// Marcador FXML.
  private RadioButton t2Velocidade50;// Para Velocidade 50 do trem 2.
  @FXML// Marcador FXML.
  private RadioButton t2Velocidade75;// Para Velocidade 75 do trem 2.
  @FXML// Marcador FXML.
  private RadioButton t2Velocidade100;// Para Velocidade 100 do trem 2.

  // Botoes
  @FXML// Marcador FXML.
  private Button btnComecar;// Para comecar o programa.
  @FXML// Marcador FXML.
  private Button btnIniciar;//Para iniciar a animacao.
  @FXML// Marcador FXML.
  private Button btnResetar;// Para resetar a animacao do ponto inicial.

  // Transicoes de caminho para as animacoes
  PathTransition p1 = new PathTransition();// Para o trem 1.
  PathTransition p2 = new PathTransition();// Para o trem 2.

  // Caminhos para as animacoes dos trens
  Path caminhoTrem1Inferior = new Path();// Trem 1 inferior.
  Path caminhoTrem2Inferior = new Path();// Trem 2 inferior.
  Path caminhoTrem1Superior = new Path();// Trem 1 superior.
  Path caminhoTrem2Superior = new Path();// Trem 2 superior.


/* ***************************************************************
* Metodo: initialize
* Funcao: Inicializa a interface e define a visibilidade inicial dos elementos.
* Parametros: location (URL do local do arquivo de FXML), resources (Pacote de recursos).
* Retorno: nenhum (void).
*************************************************************** */
  @Override// Indica que o método a seguir está sendo sobrescrito.
  public void initialize(URL location, ResourceBundle resources) {
    anchorPanePrincipal.setVisible(true);// Define o painel principal como visivel.
    anchorPaneDirecao.setVisible(false);// Define o painel de direcao como invisivel.
    anchorPaneVelocidade.setVisible(false);// Define o painel de velocidade como invisivel.
    anchorPaneStatusTrens.setVisible(false);// Define o painel de status dos trens como invisivel.

    direcaoDePartida.setVisible(false);// Define o label de direcao de partida como invisivel.

    trilho.setVisible(false);// Define o trilho como invisivel.
    trem1.setVisible(false);// Define o trem 1 como invisivel.
    trem2.setVisible(false);// Define o trem 2 principal como invisivel.

    btnIniciar.setVisible(false);// Define o botao 'Iniciar' como invisivel.
  }

/* ***************************************************************
* Metodo: clickOnComecar
* Funcao: Responde ao clique no botao "Começar", exibindo elementos relacionados a escolha de direcao.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void clickOnComecar(ActionEvent event) throws IOException {
    anchorPaneDirecao.setVisible(true);// Torna o painel de direcao visivel.
    direcaoDePartida.setVisible(true);// Torna a label de direcao de partida visivel.

    trilho.setVisible(true);// Torna o componente de trilho visivel.

    btnComecar.setVisible(false);// Torna o botao "Começar" invisivel.
  }

/* ***************************************************************
* Metodo: onClickbtnAlternadoI
* Funcao: Acao ao selecionar a direcao "Alternado I". Posiciona os trens e configura botoes.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void onClickbtnAlternadoI(ActionEvent event) throws IOException {
    trem1.setVisible(true);// Torna o trem1 visivel.
    trem1.setRotate(90);// Define sua rotacao.
    trem1.setLayoutX(21);// Define posicao em X.
    trem1.setLayoutY(0);// Define posicao em Y.

    trem2.setVisible(true);// Torna o trem2 visivel.
    trem2.setRotate(-90);// Define sua rotacao.
    trem2.setLayoutX(122);// Define posicao em X.
    trem2.setLayoutY(402);// Define posicao em Y.

    btnIniciar.setVisible(true);// Torna o botao "Iniciar" visivel.
    btnComecar.setVisible(false);// Torna o botao "Comecar" invisivel.
  }

/* ***************************************************************
* Metodo: onClickbtnAlternadoII
* Funcao: Acao ao selecionar a direcao "Alternado II". Posiciona os trens e configura botoes.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void onClickbtnAlternadoII(ActionEvent event) throws IOException {
    trem1.setVisible(true);// Torna o trem1 visivel.
    trem1.setRotate(-90);// Define sua rotacao.
    trem1.setLayoutX(21);// Define posicao em X.
    trem1.setLayoutY(402);// Define posicao em Y.

    trem2.setVisible(true);// Torna o trem2 visivel.
    trem2.setRotate(90);// Define sua rotacao.
    trem2.setLayoutX(122);// Define posicao em X.
    trem2.setLayoutY(0);// Define posicao em Y.

    btnIniciar.setVisible(true);// Torna o botao "Iniciar" visivel.
    btnComecar.setVisible(false);// Torna o botao "Comecar" invisivel.
  }

/* ***************************************************************
* Metodo: onClickbtnInferior
* Funcao: Acao ao selecionar a direcao "Inferior". Posiciona os trens e configura botoes.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void onClickbtnInferior(ActionEvent event) throws IOException {
    trem1.setVisible(true);// Torna o trem1 visivel.
    trem1.setRotate(-90);// Define sua rotacao.
    trem1.setLayoutX(21);// Define posicao em X.
    trem1.setLayoutY(402);// Define posicao em Y.

    trem2.setVisible(true);// Torna o trem2 visivel.
    trem2.setRotate(-90);// Define sua rotacao.
    trem2.setLayoutX(122);// Define posicao em X.
    trem2.setLayoutY(402);// Define posicao em Y.

    btnIniciar.setVisible(true);// Torna o botao "Iniciar" visivel.
    btnComecar.setVisible(false);// Torna o botao "Comecar" invisivel.
  }

/* ***************************************************************
* Metodo: onClickbtnSuperior
* Funcao: Acao ao selecionar a direcao "Superior". Posiciona os trens e configura botoes.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void onClickbtnSuperior(ActionEvent event) throws IOException {
    trem1.setVisible(true);// Torna o trem1 visivel.
    trem1.setRotate(90);// Define sua rotacao.
    trem1.setLayoutX(21);// Define posicao em X.
    trem1.setLayoutY(0);// Define posicao em Y.

    trem2.setVisible(true);// Torna o trem2 visivel.
    trem2.setRotate(90);// Define sua rotacao.
    trem2.setLayoutX(122);// Define posicao em X.
    trem2.setLayoutY(0);// Define posicao em Y.

    btnIniciar.setVisible(true);// Torna o botao "Iniciar" visivel.
    btnComecar.setVisible(false);// Torna o botao "Comecar" invisivel.
  }

/* ***************************************************************
* Metodo: onClickbtnIniciar
* Funcao: Inicia a etapa de animações dos trens e exibe o status dos trens na interface.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void onClickbtnIniciar(ActionEvent event) throws IOException {
    direcaoDePartida.setVisible(false);// Oculta a label de direcao de partida.
    anchorPaneDirecao.setVisible(false);// Oculta o label de painel de direcao.

    anchorPaneVelocidade.setVisible(true);// Torna o painel de velocidade visivel.

    btnIniciar.setVisible(false); // Torna o botão "Iniciar" invisivel.

    anchorPaneStatusTrens.setVisible(true);// Torna o painel de status dos trens visivel.
    // Define a visibilidade inicial dos status dos trens.(status 0km/h(PARADO) para trem 1 e trem 2).
    status0Trem1.setVisible(true);
    status25Trem1.setVisible(false);
    status50Trem1.setVisible(false);
    status75Trem1.setVisible(false);
    status100Trem1.setVisible(false);
    status0Trem2.setVisible(true);
    status25Trem2.setVisible(false);
    status50Trem2.setVisible(false);
    status75Trem2.setVisible(false);
    status100Trem2.setVisible(false);

	// Executa animacoes chamando o metodo de acordo com a direcao selecionada(SUPERIOR)
    if (btnSuperior.isSelected()) {
      animacaoTrem1Superior();
      animacaoTrem2Superior();
    }

    // Executa animacoes chamando o metodo de acordo com a direcao selecionada(INFERIOR)
    if (btnInferior.isSelected()) {
      animacaoTrem1Inferior();
      animacaoTrem2Iinferior();
    }

    // Executa animacoes chamando o metodo de acordo com a direcao selecionada(ALTERNADO I)
    if (btnAlternadoI.isSelected()) {
      animacaoTrem1Superior();
      animacaoTrem2Iinferior();
    }

    // Executa animacoes chamando o metodo de acordo com a direcao selecionada(ALTERNADO II)
    if (btnAlternadoII.isSelected()) {
      animacaoTrem1Inferior();
      animacaoTrem2Superior();
    }

    t1Velocidade0.setSelected(true);// Define a velocidade inicial 0(PARADO) selecionada para o trem 1
    t2Velocidade0.setSelected(true);// Define a velocidade inicial 0(PARADO) selecionada para o trem 2
  }

/* ***************************************************************
* Metodo: clickOnT1Velocidade0
* Funcao: Acao de pausar ao selecionar a velocidade 0 para o trem 1.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void clickOnT1Velocidade0(ActionEvent event) throws IOException {
  	// Mostra o status correspondente ao trem 1 com velocidade 0(PARADO).
    status0Trem1.setVisible(true);
    status25Trem1.setVisible(false);
    status50Trem1.setVisible(false);
    status75Trem1.setVisible(false);
    status100Trem1.setVisible(false);
    p1.pause();// Pausa a animacao do trem 1.
  }

/* ***************************************************************
* Metodo: clickOnT1Velocidade25
* Funcao: Acao de 25Km/h ao selecionar a velocidade 25 para o trem 1.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void clickOnT1Velocidade25(ActionEvent event) throws IOException {
  	// Mostra o status correspondente ao trem 1 com velocidade 25.
    status0Trem1.setVisible(false);
    status25Trem1.setVisible(true);
    status50Trem1.setVisible(false);
    status75Trem1.setVisible(false);
    status100Trem1.setVisible(false);
    p1.play();// play da animacao do trem 1.
    p1.setRate(0.25);// Define a taxa de reproducao da animacao do trem 1 para 0.25 (25% da velocidade original).
  }

/* ***************************************************************
* Metodo: clickOnT1Velocidade50
* Funcao: Acao de 50Km/h ao selecionar a velocidade 50 para o trem 1.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void clickOnT1Velocidade50(ActionEvent event) throws IOException {
  	// Mostra o status correspondente ao trem 1 com velocidade 50.
    status0Trem1.setVisible(false);
    status25Trem1.setVisible(false);
    status50Trem1.setVisible(true);
    status75Trem1.setVisible(false);
    status100Trem1.setVisible(false);
    p1.play();// play da animacao do trem 1.
    p1.setRate(0.5);// Define a taxa de reproducao da animacao do trem 1 para 0.5 (50% da velocidade original).
  }

/* ***************************************************************
* Metodo: clickOnT1Velocidade75
* Funcao: Acao de 75Km/h ao selecionar a velocidade 75 para o trem 1.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void clickOnT1Velocidade75(ActionEvent event) throws IOException {
  	// Mostra o status correspondente ao trem 1 com velocidade 75.
    status0Trem1.setVisible(false);
    status25Trem1.setVisible(false);
    status50Trem1.setVisible(false);
    status75Trem1.setVisible(true);
    status100Trem1.setVisible(false);
    p1.play();// play da animacao do trem 1.
    p1.setRate(0.75);// Define a taxa de reproducao da animacao do trem 1 para 0.75 (75% da velocidade original).
  }

/* ***************************************************************
* Metodo: clickOnT1Velocidade100
* Funcao: Acao de 100Km/h ao selecionar a velocidade 100 para o trem 1.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void clickOnT1Velocidade100(ActionEvent event) throws IOException {
  	// Mostra o status correspondente ao trem 1 com velocidade 100.
    status0Trem1.setVisible(false);
    status25Trem1.setVisible(false);
    status50Trem1.setVisible(false);
    status75Trem1.setVisible(false);
    status100Trem1.setVisible(true);
    p1.play();// play da animacao do trem 1.
    p1.setRate(1);// Define a taxa de reproducao da animacao do trem 1 para 1 (100% da velocidade original).
  }

/* ***************************************************************
* Metodo: clickOnT2Velocidade0
* Funcao: Acao de pausar ao selecionar a velocidade 0 para o trem 2.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void clickOnT2Velocidade0(ActionEvent event) throws IOException {
  	// Mostra o status correspondente ao trem 2 com velocidade 0(PARADO).
    status0Trem2.setVisible(true);
    status25Trem2.setVisible(false);
    status50Trem2.setVisible(false);
    status75Trem2.setVisible(false);
    status100Trem2.setVisible(false);
    p2.pause();// Pausa a animacao do trem 2.
  }

/* ***************************************************************
* Metodo: clickOnT2Velocidade25
* Funcao: Acao de 25Km/h ao selecionar a velocidade 25 para o trem 2.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void clickOnT2Velocidade25(ActionEvent event) throws IOException {
  	// Mostra o status correspondente ao trem 2 com velocidade 25.
    status0Trem2.setVisible(false);
    status25Trem2.setVisible(true);
    status50Trem2.setVisible(false);
    status75Trem2.setVisible(false);
    status100Trem2.setVisible(false);
    p2.play();// play da animacao do trem 2.
    p2.setRate(0.25);// Define a taxa de reproducao da animacao do trem 2 para 0.25 (25% da velocidade original).

  }

/* ***************************************************************
* Metodo: clickOnT2Velocidade50
* Funcao: Acao de 50Km/h ao selecionar a velocidade 50 para o trem 2.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void clickOnT2Velocidade50(ActionEvent event) throws IOException {
  	// Mostra o status correspondente ao trem 2 com velocidade 50.
    status0Trem2.setVisible(false);
    status25Trem2.setVisible(false);
    status50Trem2.setVisible(true);
    status75Trem2.setVisible(false);
    status100Trem2.setVisible(false);
    p2.play();// play da animacao do trem 2.
    p2.setRate(0.5);// Define a taxa de reproducao da animacao do trem 2 para 0.5 (50% da velocidade original).

  }

/* ***************************************************************
* Metodo: clickOnT2Velocidade75
* Funcao: Acao de 75Km/h ao selecionar a velocidade 75 para o trem 2.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void clickOnT2Velocidade75(ActionEvent event) throws IOException {
  	// Mostra o status correspondente ao trem 2 com velocidade 75.
    status0Trem2.setVisible(false);
    status25Trem2.setVisible(false);
    status50Trem2.setVisible(false);
    status75Trem2.setVisible(true);
    status100Trem2.setVisible(false);
    p2.play();// play da animacao do trem 2.
    p2.setRate(0.75);// Define a taxa de reproducao da animacao do trem 2 para 0.75 (75% da velocidade original).

  }

/* ***************************************************************
* Metodo: clickOnT2Velocidade100
* Funcao: Acao de 100Km/h ao selecionar a velocidade 100 para o trem 2.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void clickOnT2Velocidade100(ActionEvent event) throws IOException {
  	// Mostra o status correspondente ao trem 2 com velocidade 100.
    status0Trem2.setVisible(false);
    status25Trem2.setVisible(false);
    status50Trem2.setVisible(false);
    status75Trem2.setVisible(false);
    status100Trem2.setVisible(true);
    p2.play();// play da animacao do trem 2.
    p2.setRate(1);// Define a taxa de reproducao da animacao do trem 2 para 1 (100% da velocidade original).

  }

/* ***************************************************************
* Metodo: animacaoTrem1Superior
* Funcao: Define a animacao do trem 1 seguindo um caminho superior.
* Parametros: Nenhum.
* Retorno: Nenhum (void).
*************************************************************** */
  public void animacaoTrem1Superior() {
  	// Define o caminho do trem 1 na animacao, usando elementos MoveTo(inicio da animacao) e LineTo(fim da animacao).
    caminhoTrem1Superior.getElements().add(new MoveTo(24, 20));
    caminhoTrem1Superior.getElements().addAll(
      new LineTo(24, 60),
      new LineTo(74, 95),
      new LineTo(74, 175),
      new LineTo(124, 200),
      new LineTo(124, 263),
      new LineTo(74, 298),
      new LineTo(74, 358),
      new LineTo(24, 383),
      new LineTo(24, 450));
    // Configuracoes da animacao p1 para o trem 1.
    p1.setDuration(Duration.seconds(3));// Duracao da animacao.
    p1.setPath(caminhoTrem1Superior);// Caminho.
    p1.setNode(trem1);// Objeto que vai se mover no caminho (trem 1).
    p1.setCycleCount(PathTransition.INDEFINITE);// Tornar ciclico.
    p1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);// Tornar curvas naturais.
    p1.setAutoReverse(false);// Proibir que volte("andar de re") o caminho.
  }

/* ***************************************************************
* Metodo: animacaoTrem2Superior
* Funcao: Define a animacao do trem 2 seguindo um caminho superior.
* Parametros: Nenhum.
* Retorno: Nenhum (void).
*************************************************************** */
  public void animacaoTrem2Superior() {
  	// Define o caminho do trem 2 na animacao, usando elementos MoveTo(inicio da animacao) e LineTo(fim da animacao).
    caminhoTrem2Superior.getElements().add(new MoveTo(24, 20));
    caminhoTrem2Superior.getElements().addAll(
      new LineTo(24, 60),
      new LineTo(-26, 95),
      new LineTo(-26, 175),
      new LineTo(-76, 200),
      new LineTo(-76, 263),
      new LineTo(-26, 298),
      new LineTo(-26, 358),
      new LineTo(24, 383),
      new LineTo(24, 450));
    // Configuracoes da animacao p2 para o trem 2.
    p2.setDuration(Duration.seconds(3));// Duracao da animacao.
    p2.setPath(caminhoTrem2Superior);// Caminho.
    p2.setNode(trem2);// Objeto que vai se mover no caminho (trem 2).
    p2.setCycleCount(PathTransition.INDEFINITE);// Tornar ciclico.
    p2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);// Tornar curvas naturais.
    p2.setAutoReverse(false);// Proibir que volte("andar de re") o caminho.
  }

/* ***************************************************************
* Metodo: animacaoTrem1Inferior
* Funcao: Define a animacao do trem 1 seguindo um caminho inferior.
* Parametros: Nenhum.
* Retorno: Nenhum (void).
*************************************************************** */
  public void animacaoTrem1Inferior() {
  	// Define o caminho do trem 1 na animacao, usando elementos MoveTo(inicio da animacao) e LineTo(fim da animacao).
    caminhoTrem1Inferior.getElements().add(new MoveTo(24, 20));
    caminhoTrem1Inferior.getElements().addAll(
      new LineTo(24, -23),
      new LineTo(74, -50),
      new LineTo(74, -110),
      new LineTo(124, -137),
      new LineTo(124, -200),
      new LineTo(74, -235),
      new LineTo(74, -315),
      new LineTo(24, -340),
      new LineTo(24, -400));
    // Configuracoes da animacao p1 para o trem 1.
    p1.setDuration(Duration.seconds(3));// Duracao da animacao.
    p1.setPath(caminhoTrem1Inferior);// Caminho.
    p1.setNode(trem1);// Objeto que vai se mover no caminho (trem 1).
    p1.setCycleCount(PathTransition.INDEFINITE);// Tornar ciclico.
    p1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);// Tornar curvas naturais.
    p1.setAutoReverse(false);// Proibir que volte("andar de re") o caminho.
  }

/* ***************************************************************
* Metodo: animacaoTrem2Inferior
* Funcao: Define a animacao do trem 2 seguindo um caminho inferior.
* Parametros: Nenhum.
* Retorno: Nenhum (void).
*************************************************************** */
  public void animacaoTrem2Iinferior() {
  	// Define o caminho do trem 2 na animacao, usando elementos MoveTo(inicio da animacao) e LineTo(fim da animacao).
    caminhoTrem2Inferior.getElements().add(new MoveTo(24, 20));
    caminhoTrem2Inferior.getElements().addAll(
      new LineTo(24, -23),
      new LineTo(-26, -50),
      new LineTo(-26, -110),
      new LineTo(-76, -137),
      new LineTo(-76, -200),
      new LineTo(-26, -235),
      new LineTo(-26, -315),
      new LineTo(24, -340),
      new LineTo(24, -400));
    // Configuracoes da animacao p2 para o trem 2.
    p2.setDuration(Duration.seconds(3));// Duracao da animacao.
    p2.setPath(caminhoTrem2Inferior);// Caminho.
    p2.setNode(trem2);// Objeto que vai se mover no caminho (trem 1).
    p2.setCycleCount(PathTransition.INDEFINITE);// Tornar ciclico.
    p2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);// Tornar curvas naturais.
    p2.setAutoReverse(false);// Proibir que volte("andar de re") o caminho.
  }

/* ***************************************************************
* Metodo: clickOnBtnResetar
* Funcao: Reinicia a simulacao, redefinindo animacoes, velocidades e estados iniciais dos trens.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: Nenhum (void).
*************************************************************** */
  @FXML// Marcador FXML.
  void clickOnBtnResetar(ActionEvent event) throws IOException {
  	// Reinicia as animacoes dos trens a partir do inicio.
    p1.playFrom(Duration.seconds(0));
    p2.playFrom(Duration.seconds(0));
    // Para as animacoes dos trens.
    p1.stop();
    p2.stop();

    p1.play();
    p2.play();
        
    p1.setRate(0);
    p2.setRate(0);

    // Define a velocidade 0 para ambos os trens.
    t1Velocidade0.setSelected(true);
    t2Velocidade0.setSelected(true);

    // Define o status de velocidade inicial do trem 1(PARADO).
    status0Trem1.setVisible(true);
    status25Trem1.setVisible(false);
    status50Trem1.setVisible(false);
    status75Trem1.setVisible(false);
    status100Trem1.setVisible(false);
    // Define o status de velocidade inicial do trem 2(PARADO).
    status0Trem2.setVisible(true);
    status25Trem2.setVisible(false);
    status50Trem2.setVisible(false);
    status75Trem2.setVisible(false);
    status100Trem2.setVisible(false);
  }
}