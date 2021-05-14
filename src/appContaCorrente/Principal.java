package appContaCorrente;

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        String tipoContas[] = {"Conta Corrente Simples", "Conta Corrente Especial"};

        String operacoes[] = {"Depositar", "Sacar", "Consultar Saldo", "Sair"};
        
        String opUsr="";
        float valor;

        String numConta = JOptionPane.showInputDialog(null, "Informe o número da conta", "Abertura de Conta Corrente", JOptionPane.QUESTION_MESSAGE);
        String nomeTitular = JOptionPane.showInputDialog(null, "Informe o nome do cliente", "Abertura de Conta Corrente", JOptionPane.QUESTION_MESSAGE);
        String sobrenomeTitular = JOptionPane.showInputDialog(null, "Informe o sobrenome de "+nomeTitular, "Abertura de Conta Corrente", JOptionPane.QUESTION_MESSAGE);
       
        Pessoa titular;
        if (JOptionPane.showConfirmDialog(null, "Deseja informar o CPF do titular?", "Abertura de Conta Corrente", JOptionPane.YES_NO_OPTION) == 0) {
            String cpf = JOptionPane.showInputDialog(null, "Informe o CPF de " + nomeTitular, "Abertura de Conta Corrente", JOptionPane.QUESTION_MESSAGE);
            titular = new Pessoa(nomeTitular, sobrenomeTitular, cpf);
        } else {
            titular = new Pessoa(nomeTitular, sobrenomeTitular);
        }

        
         String tipoConta = (String) JOptionPane.showInputDialog(null, "Selecione o tipo da conta de " + nomeTitular, "Abertura de Conta Corrente", JOptionPane.QUESTION_MESSAGE,
                                                                                                       null, tipoContas, tipoContas[0]);
        
         ContaCorrente conta;
         
        if (tipoConta.equals(tipoContas[0])) {
             conta = new ContaCorrente(numConta, titular); 
        }else{
            conta = new ContaEspecial(numConta, titular); //associa, ao objeto da classe mãe (ContaCorrente) a referência do objeto da classe filha ContaEspecial
        }
       
        //Exibe na tela as informações da conta selecionada pelo usuário do aplicativo
       JOptionPane.showMessageDialog(null, conta.dados(), "Abertura de Conta Corrente", JOptionPane.INFORMATION_MESSAGE);

        //a estrutura a seguir permite a manipulação das operações na conta
            while (!opUsr.equals(operacoes[3])) {
                opUsr = (String) JOptionPane.showInputDialog(null, "Digite a operação desejada: ", "Movimentação de Conta Corrente", 3, null, operacoes, operacoes[0]);

                switch (opUsr) {

                    case "Depositar":
                        valor = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor do depósito", "Movimentação de Conta Corrente", JOptionPane.QUESTION_MESSAGE));
                        conta.depositar(valor);
                        break;

                    case "Sacar":
                        valor = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor do saque", "Movimentação de Conta Corrente", JOptionPane.QUESTION_MESSAGE));
                        boolean sacou = conta.sacar(valor);
                        if (sacou) {
                            JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso", "Movimentação de Conta Corrente", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "SAQUE NÃO REALIZADO." + "SALDO INSUFICIENTE!!!!!", "Movimentação de Conta Corrente", JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case "Consultar Saldo":
                        JOptionPane.showMessageDialog(null, conta.dados(), "Movimentação de Conta Corrente", JOptionPane.INFORMATION_MESSAGE);
                }//fim da estrutura Switch
            }//fim da estrutura while
          System.exit(0);
    }//fim do main
}//fim da classe

