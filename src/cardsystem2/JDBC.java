package cardsystem2;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class JDBC {
 
    String nombre,apellido,telefono,email,tag,saldo,compra,image,empresa;
    
    Integer actualsaldo;
	public void conex() {
 
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
 
		try {
 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/MiSaldo", "misaldo",
					"chichi");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
                try{
                    
                
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
                while (rs.next()) {
                    System.out.print("Column 1 returned ");
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString(4));
                    
                }
                rs.close();
                st.close();
                }catch (SQLException e) {
 
			System.out.println("Sintaxis mala");
			e.printStackTrace();
			return;
 
		}
	}
        
        public void guarda_registro(String nombre, String apellido, String email, String telefono, String tag){
            this.nombre=nombre;
            this.apellido=apellido;
            this.email=email;
            this.telefono=telefono;
            this.tag=tag;

            
            System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
 
		try {
 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/MiSaldo", "misaldo",
					"chichi");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
                try{
                    
                    PreparedStatement st = connection.prepareStatement("INSERT INTO usuarios (nombres,apellidos,email,telefono,tagid)values (?,?,?,?,?)");
                    st.setString(1, nombre);
                    st.setString(2, apellido);
                    st.setString(3, email);
                    st.setString(4, telefono);
                    st.setString(5, tag);
                    int resultado = st.executeUpdate();
                    //Statement st = connection.createStatement();
                    //ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
                    
                    //rs.close();
                    if(resultado>0){
                        System.out.print("insercion correcta");
                    }
                        
                    st.close();
                }catch (SQLException e) {
 
			System.out.println("Sintaxis mala");
			e.printStackTrace();
			return;
 
		}
                
                
        }
 
        public void guarda_user(String nombre, String apellido, String email, String telefono, String tag, String image, String empresa){
            this.nombre=nombre;
            this.apellido=apellido;
            this.email=email;
            this.telefono=telefono;
            this.tag=tag;
            this.image=image;
            this.empresa=empresa;
            
            System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
 
		try {
 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/UrbanStation", "urban",
					"chichi");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
                try{
                    
                    PreparedStatement st = connection.prepareStatement("INSERT INTO Usuarios (nombre,apellido,email,telefono,tag,imagepath,empresa)values (?,?,?,?,?,?,?)");
                    st.setString(1, nombre);
                    st.setString(2, apellido);
                    st.setString(3, email);
                    st.setString(4, telefono);
                    st.setString(5, tag);
                    st.setString(6, image);
                    st.setString(7, empresa);
                    int resultado = st.executeUpdate();
                    //Statement st = connection.createStatement();
                    //ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
                    
                    //rs.close();
                    if(resultado>0){
                        System.out.print("insercion correcta");
                    }
                        
                    st.close();
                }catch (SQLException e) {
 
			System.out.println("Sintaxis mala");
			e.printStackTrace();
			return;
 
		}
                
                
        }
 
        
       public int buscartag(String tagid){
                    
                    this.tag=tagid;
                try {
 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			//return;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/MiSaldo", "misaldo",
					"chichi");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			//return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
                try{
                    
                    PreparedStatement st = connection.prepareStatement("select * from usuarios where tagid = ?");
                    st.setString(1, tag/*"040596929E3380"*/);
                    ResultSet rs = st.executeQuery();
                    //Statement st = connection.createStatement();
                    //ResultSet rs = st.executeQuery("SELECT * FROM usuarios where tagid = '");
                    
                    //rs.close();
                    if (!rs.isBeforeFirst() ) {    
                        System.out.println("No data"); 
                        st.close();
                        return 0;
                       }else{
                        while (rs.next()) {
                            //System.out.print("Column 1 returned ");
                            this.nombre=rs.getString(1);
                            this.apellido=rs.getString(2);
                            this.email=rs.getString(3);
                            this.telefono=rs.getString(5);
                            this.saldo=rs.getString(7);

                        }
                        rs.close();
                        st.close();
                        return 1;
                    } 
                    
                        
                    
                }catch (SQLException e) {
 
			System.out.println("Sintaxis mala");
			e.printStackTrace();
			//return;
 
		}
                return 0;
                } 
       
       public String getnombre(){
           return nombre;
       }
       public String getapellido(){
           return apellido;
       }
       public String getemail(){
           return email;
       }
       public String gettelefono(){
           return telefono;
       }
       public String getsaldo(){
           return saldo;
       }
       public void carga_saldo(String saldo, String tag){
           this.saldo=saldo;
           this.tag=tag;
           System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
 
		try {
 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/MiSaldo", "misaldo",
					"chichi");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
                try{
                    PreparedStatement st = connection.prepareStatement("SELECT saldo from usuarios where tagid=?");
                    st.setString(1, tag);
                    ResultSet rs = st.executeQuery();
                    while(rs.next()){
                    this.actualsaldo=rs.getInt(1);
                    }
                    actualsaldo=Integer.valueOf(saldo)+actualsaldo;
                    
                    st = connection.prepareStatement("UPDATE usuarios SET saldo = ? where tagid=?");
                    st.setInt(1, actualsaldo);
                    st.setString(2, tag);
                    
                    int resultado = st.executeUpdate();
                    //Statement st = connection.createStatement();
                    //ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
                    
                    //rs.close();
                    if(resultado>0){
                        System.out.print("insercion correcta");
                    }
                        
                    st.close();
                }catch (SQLException e) {
 
			System.out.println("Sintaxis mala");
			e.printStackTrace();
			return;
 
		}
       }
       public int descontar_saldo(String compra, String tag){
           this.compra=compra;
           this.tag=tag;
           System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
 
		try {
 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			//return;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/MiSaldo", "misaldo",
					"chichi");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			//return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
                try{
                    PreparedStatement st = connection.prepareStatement("SELECT saldo from usuarios where tagid=?");
                    st.setString(1, tag);
                    ResultSet rs = st.executeQuery();
                    while(rs.next()){
                    this.actualsaldo=rs.getInt(1);
                    }
                    actualsaldo=actualsaldo-Integer.valueOf(compra);
                    if(actualsaldo<0){
                        System.out.println("Saldo insuficiente");
                        return -1;
                    }else{
                        st = connection.prepareStatement("UPDATE usuarios SET saldo = ? where tagid=?");
                        st.setInt(1, actualsaldo);
                        st.setString(2, tag);

                        int resultado = st.executeUpdate();
                        //Statement st = connection.createStatement();
                        //ResultSet rs = st.executeQuery("SELECT * FROM usuarios");

                        //rs.close();
                        if(resultado>0){
                            System.out.print("insercion correcta");
                    }
                        
                    st.close();
                    return actualsaldo;
                    }
                    
                    
                }catch (SQLException e) {
 
			System.out.println("Sintaxis mala");
			e.printStackTrace();
			//return;
 
		}
                return 0;
       }
}