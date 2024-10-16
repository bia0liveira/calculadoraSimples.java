import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JButton botaoSoma;
    private JButton botaoSubtracao;
    private JButton botaoMultiplicacao;
    private JButton botaoDivisao;

    public App() {
        criarComponentes();
        definirLayout();
        adicionarAcoes();
        configurarJanela();
    }

    private void criarComponentes() {
        campoNumero1 = new JTextField(5);
        campoNumero2 = new JTextField(5);

        botaoSoma = new JButton("+");
        botaoSubtracao = new JButton("-");
        botaoMultiplicacao = new JButton("*");
        botaoDivisao = new JButton("/");
    }

    private void definirLayout() {
        setLayout(new GridLayout(2, 2, 5, 5));

        add(new JLabel("Número 1:"));
        add(campoNumero1);
        add(new JLabel("Número 2:"));
        add(campoNumero2);

        add(botaoSoma);
        add(botaoSubtracao);
        add(botaoMultiplicacao);
        add(botaoDivisao);
    }

    private void adicionarAcoes() {
        botaoSoma.addActionListener(new Operacao("+"));
        botaoSubtracao.addActionListener(new Operacao("-"));
        botaoMultiplicacao.addActionListener(new Operacao("*"));
        botaoDivisao.addActionListener(new Operacao("/"));
    }

    private void configurarJanela() {
        setTitle("Calculadora");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class Operacao implements ActionListener {
        private String operacao;

        public Operacao(String operacao) {
            this.operacao = operacao;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double numero1 = Double.parseDouble(campoNumero1.getText());
                double numero2 = Double.parseDouble(campoNumero2.getText());
                double resultado = 0;

                switch (operacao) {
                    case "+":
                        resultado = numero1 + numero2;
                        break;
                    case "-":
                        resultado = numero1 - numero2;
                        break;
                    case "*":
                        resultado = numero1 * numero2;
                        break;
                    case "/":
                        if (numero2 != 0) {
                            resultado = numero1 / numero2;
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro: Divisão por zero!");
                            return;
                        }
                        break;
                }

                JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, insira números válidos!");
            }
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
