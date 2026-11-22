package uniceplac_Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Produto {

public static void main(String[] args)
{

// conexão no Railway (preencha com os dados do MySQL do Railway:
// Variables / Connect > "Public Network" -> host, porta, usuário e senha)

String host = "COLE_O_HOST_AQUI";      // ex: roundhouse.proxy.rlwy.net
String porta = "COLE_A_PORTA_AQUI";    // ex: 12345
String banco = "railway";              // nome do banco (MYSQL_DATABASE)

String url = "jdbc:mysql://" + host + ":" + porta + "/" + banco
        + "?useSSL=false&allowPublicKeyRetrieval=true";
String usuariobanco = "root";
String bancosenha = "COLE_A_SENHA_AQUI";


Scanner sc = new Scanner(System.in);
try
{

Connection conexao = DriverManager.getConnection(url, usuariobanco, bancosenha);

int opcao = -1;
while(opcao != 0) {
System.out.println("1 - Inserir | 2 - Listar | 3 - Atualizar | 4 - Deletar | 0 - Sair ");

opcao = sc.nextInt();
sc.nextLine();

switch(opcao) {

case 1:
System.out.print("Código do produto: ");
int codigo = sc.nextInt();

System.out.print("Nome do produto: ");
String nome = sc.next();

System.out.println("Preço do produto: ");
float preco = sc.nextFloat();

String sql = "INSERT INTO PRODUTO (CODIGO, NOME, PRECO) VALUES (?, ?, ? )";

PreparedStatement stmt = conexao.prepareStatement(sql);
stmt.setInt(1, codigo);
stmt.setString(2, nome);
stmt.setFloat(3, preco);
stmt.executeUpdate();


case 2:
System.out.println("Digite o código do produto");
int codigo2 = sc.nextInt();

String sql2 = "SELECT * FROM PRODUTO WHERE CODIGO = ? ";
PreparedStatement stmt2 = conexao.prepareStatement(sql2);
stmt2.setInt(1 , codigo2);
ResultSet rs = stmt2.executeQuery();
while(rs.next()) {

System.out.println("Nome produto: " + rs.getString("nome") + "Preço: " + rs.getFloat("preco0"));

}

case 3:


case 4:


default:
System.out.println("Opção inválida!!!");


}












}







} catch (Exception E) {

System.out.println("Erro de cadastro" + E.getMessage());

}

}

}
