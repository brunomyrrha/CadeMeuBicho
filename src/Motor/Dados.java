package Motor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author brunomyrrha
 */
public class Dados {
        private Connection conexao = null;
        private Dica dica;
        private final ArrayList <Dica> database = new ArrayList<>();
        private int qtdLinhas = 0;
        
        public Connection Conectar () throws Exception {
            final String url = "jdbc:mysql://us-cdbr-azure-central-a.cloudapp.net/cademeubicho";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection(url,"bb3f7b5052f129","4881742c");
                System.out.println("Conexão efetuada com sucesso.");
                
            }catch (Exception e){
                System.out.println("Erro ao conectar ao banco de dados.");
                conexao.close();
            }
            return conexao;    
        }
        
        public void importarBanco () throws Exception {
            String query = "SELECT * from Dados;";
            ResultSet rs = conexao.prepareStatement(query).executeQuery();
            while (rs.next()){
                dica = new Dica(rs.getInt(1),"<html><left>"+rs.getString(2)+"</left></html>",rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6));
                database.add(dica);
                qtdLinhas++;
            }  
        }
        
        public ArrayList retornaBanco (){
            return database;
        }
        
        public int retornaQtdLinhas(){
            return qtdLinhas;
        }
        
}
