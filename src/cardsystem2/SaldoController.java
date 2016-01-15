/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardsystem2;




import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Tsunderella
 */
public class SaldoController implements Initializable{
    private Desktop desktop = Desktop.getDesktop();
    @FXML
    private Label label;
    @FXML
    private TextField tagtext1,nombreread,apellidoread,telefonoread,emailread;
    @FXML
    private TextField saldoread,text_tagventa;
    @FXML
    private TextField tagtext2,nombrereg,apellidoreg,telefonoreg,emailreg,empresa;
    @FXML
    private TextField tagtext3,saldoreg;
    @FXML
    private TextField tag_venta,text_saldotag,text_saldoventa;
    @FXML
    private CheckBox producto1_check,producto2_check,producto3_check,jhonny_plat_check,whiskey_check,rum_check,vodka_check,gin_check,fruit_check,wine_check,water_check,natural_check,noalcohol_check;
    @FXML
    private TextField producto1,producto2,producto3,jhonny_plat,whiskey,rum,vodka,gin,fruit,wine,water,natural,noalcohol,total;
    @FXML
    private TextField total_venta;
    @FXML Pane ingreso;
    final FileChooser fileChooser = new FileChooser();
    @FXML
    Parent root;
    @FXML
    ImageView imagen;
    @FXML
    Tab tab2,tab3,tab4;
    
    int suma = 0;
    private String uid,image_path;
    //@FXML
    //final ObservableList<String> prod = FXCollections.observableArrayList("Producto 1", "Producto 2", "Producto 3","Producto 4","Producto 5","Producto 6"),venta =FXCollections.observableArrayList();
    //@FXML
   // private ListView<String> lista_prod,lista_venta;
    
    private final ObservableList<Productos> datos = FXCollections.observableArrayList(
                new Productos("Producto 1","10000"),
                new Productos("Producto 2","5000"),
                new Productos("Producto 3","7500"),
                new Productos("Producto 4","7500"));;
    private final ObservableList<Productos> datos2 = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Productos> tabla_prod;
    @FXML
    private TableView<Productos> tabla_venta;
    
    @FXML
    private TableColumn<Productos, String> tabla_producto1;
    @FXML
    private TableColumn<Productos, String> tabla_precio1,tabla_precio2,tabla_producto2;//, tabla_producto2,tabla_precio2; 
    @FXML
    private ComboBox combo_categoria;
    @FXML
    protected void addPerson(ActionEvent event) {
        ObservableList<Productos> data = tabla_prod.getItems();
        data.add(new Productos("Prueba",
            "1000"));
    }
    
    
    /*public SaldoController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
"FXMLDocument.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }*/
   /* public void popup() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

            Stage secondstage = new Stage();

            secondstage.setScene(new Scene(root));

            secondstage.show();

    }*/
    private Stage myStage;
    public void setStage(Stage stage) {
         myStage = stage;
    }
    @FXML
    private void leertag(ActionEvent event) throws Exception {
        System.out.println("You clicked me!");
        
        
        Label secondLabel = new Label("Acerque Tag al lector");
                
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
                 
                Scene secondScene = new Scene(secondaryLayout, 200, 100);
 
                Stage secondStage = new Stage();
                secondStage.setTitle("Lector");
                secondStage.setScene(secondScene);
                 
                //Set position of second window, related to primary window.
                
  
                secondStage.show();
//        //label.setText("Hello World!");
//                Thread.sleep(1000);
        
        Task<Integer> task;
        task = new Task<Integer>(){
            @Override protected Integer call() throws Exception{
//                int iterations;
//                for(iterations = 0; iterations < 10; iterations++){
//                    if(isCancelled()){
//                        break;
//                    }
//                    System.out.println("Iteration " + iterations);
//                    Thread.sleep(3000);
//                }
//                return iterations;
                CardTest cardtest = new CardTest();
                uid=cardtest.cardsearch(true);
                if (!"".equals(uid)){
                    System.out.println("Encontro y cerro ventana");
                    //Thread.sleep(3000);
                    
                    //label.setText(uid);
                    Platform.runLater(() -> {
                        secondStage.hide();
                        tagtext1.setText(uid.trim());
//                        JDBC jdbc = new JDBC();
//                        if(jdbc.buscartag(uid.trim())==0){
//                            System.out.println("tag no encontrado");
//                            
//                        }else if(jdbc.buscartag(uid.trim())==1){
//                        nombreread.setText(jdbc.getnombre());
//                        apellidoread.setText(jdbc.getapellido());
//                        emailread.setText(jdbc.getemail());
//                        telefonoread.setText(jdbc.gettelefono());
//                        saldoread.setText(jdbc.getsaldo());
//                    }
                    });
                    
                }else if(!"vacio".equals(uid.trim())){

                    System.out.println("No encontro y cerro ventana");
                    secondStage.hide();
                }
                return 1;
            }
        };

        //start the background task
        Thread th = new Thread(task);
        th.setDaemon(true);
        System.out.println("Starting background task...");
       th.start();
       System.out.println("Background task started...");
//        Label secondLabel = new Label("Acerque Tag al lector");
//                
//                AnchorPane secondaryLayout = new AnchorPane();
//                secondaryLayout.getChildren().add(secondLabel);
//                 
//                Scene secondScene = new Scene(secondaryLayout, 260, 150);
// 
//                Stage secondStage = new Stage();
//                //secondStage.setTitle("Lector");
//                secondStage.setScene(secondScene);
//                 
//                //Set position of second window, related to primary window.
//                
//  
//                secondStage.show();
//        
//        
//        //label.setText("Hello World!");
//        //Thread.sleep(2000);
//        CardTest cardtest = new CardTest();
//        uid=cardtest.cardsearch(true);
//        if (!"".equals(uid)){
//            System.out.println("Encontro y cerro ventana");
//            secondStage.hide();
//            tagtext1.setText(uid);
//            JDBC jdbc = new JDBC();
//            if(jdbc.buscartag(uid)==0){
//                System.out.println("tag no encontrado");
//                
//            }else if(jdbc.buscartag(uid)==1){
//            nombreread.setText(jdbc.getnombre());
//            apellidoread.setText(jdbc.getapellido());
//            emailread.setText(jdbc.getemail());
//            telefonoread.setText(jdbc.gettelefono());
//            saldoread.setText(jdbc.getsaldo());
//        }
//            //label.setText(uid);
//            
//            
//        }else if(!"vacio".equals(uid)){
//            
//            System.out.println("No encontro y cerro ventana");
//            secondStage.hide();
//        }
    }
    @FXML
    private void guardar_user(ActionEvent event) throws Exception{
        JDBC guardar = new JDBC();
        guardar.guarda_user(nombreread.getText(), apellidoread.getText(), emailread.getText(), telefonoread.getText(), tagtext1.getText(),image_path, empresa.getText());
        System.out.println("Guardado");
    }
    @FXML
    private void cargarsaldo(ActionEvent event) throws Exception {
        JDBC jdbc = new JDBC();
        jdbc.carga_saldo(saldoreg.getText(), tagtext3.getText());
        System.out.println("Saldo actualizado");
    }
    @FXML
    private void busca_foto(ActionEvent event) throws Exception {
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(myStage);
                    if (file != null) {
                        System.out.println(file.getPath().toString());
                        System.out.println(file.toURI().toString());
                        image_path=file.toURI().toString();
                        Image image = new Image(file.toURI().toString());
                        imagen.setImage(image);
                        //openFile(file);
                    }
        
    }
    
    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                SaldoController.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
    private static void configureFileChooser(
        final FileChooser fileChooser) {      
            fileChooser.setTitle("View Pictures");
            
            fileChooser.setInitialDirectory(
                new File("C:\\Users\\Simple\\Dropbox\\NFC\\NetBeansProjects\\UrbanStation\\src\\Imagenes")
            );                 
            fileChooser.getExtensionFilters().addAll(
                
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("All Images", "*.*")
            );
    }
    @FXML
    private void click_producto1(ActionEvent event) throws Exception {
        if(producto1_check.isSelected()){
            System.out.println("Producto 1 Seleccionado");
            producto1.setText("5500");
        }else{
            System.out.println("Producto 1 Deseleccionado");
            producto1.setText("0");
        }
    }
    @FXML
    private void click_producto2(ActionEvent event) throws Exception {
        if(producto2_check.isSelected()){
            System.out.println("Producto 2 Seleccionado");
            producto2.setText("4500");
        }else{
            System.out.println("Producto 2 Deseleccionado");
            producto2.setText("0");
        }
    }
    @FXML
    private void click_producto3(ActionEvent event) throws Exception {
        if(producto3_check.isSelected()){
            System.out.println("Producto 3 Seleccionado");
            producto3.setText("7000");
        }else{
            System.out.println("Producto 3 Deseleccionado");
            producto3.setText("0");
        }
    }
    @FXML
    private void click_jhonny(ActionEvent event) throws Exception {
        if(jhonny_plat_check.isSelected()){
            System.out.println("Producto 3 Seleccionado");
            jhonny_plat.setText("25000");
        }else{
            System.out.println("Producto 3 Deseleccionado");
            jhonny_plat.setText("0");
        }
    }
    @FXML
    private void click_whiskey(ActionEvent event) throws Exception {
        if(whiskey_check.isSelected()){
            System.out.println("Producto 3 Seleccionado");
            whiskey.setText("20000");
        }else{
            System.out.println("Producto 3 Deseleccionado");
            whiskey.setText("0");
        }
    }
    @FXML
    private void click_rum(ActionEvent event) throws Exception {
        if(rum_check.isSelected()){
            System.out.println("Producto 3 Seleccionado");
            rum.setText("21000");
        }else{
            System.out.println("Producto 3 Deseleccionado");
            rum.setText("0");
        }
    }
    @FXML
    private void click_vodka(ActionEvent event) throws Exception {
        if(vodka_check.isSelected()){
            System.out.println("Producto 3 Seleccionado");
            vodka.setText("8500");
        }else{
            System.out.println("Producto 3 Deseleccionado");
            vodka.setText("0");
        }
    }
    @FXML
    private void click_gin(ActionEvent event) throws Exception {
        if(gin_check.isSelected()){
            System.out.println("Producto 3 Seleccionado");
            gin.setText("7000");
        }else{
            System.out.println("Producto 3 Deseleccionado");
            gin.setText("0");
        }
    }
    @FXML
    private void click_fruit(ActionEvent event) throws Exception {
        if(fruit_check.isSelected()){
            System.out.println("Producto 3 Seleccionado");
            fruit.setText("5200");
        }else{
            System.out.println("Producto 3 Deseleccionado");
            fruit.setText("0");
        }
    }
    @FXML
    private void click_wine(ActionEvent event) throws Exception {
        if(wine_check.isSelected()){
            System.out.println("Producto 3 Seleccionado");
            wine.setText("6300");
        }else{
            System.out.println("Producto 3 Deseleccionado");
            wine.setText("0");
        }
    }
    @FXML
    private void click_water(ActionEvent event) throws Exception {
        if(water_check.isSelected()){
            System.out.println("Producto 3 Seleccionado");
            water.setText("1200");
        }else{
            System.out.println("Producto 3 Deseleccionado");
            water.setText("0");
        }
    }
    @FXML
    private void click_noalcohol(ActionEvent event) throws Exception {
        if(noalcohol_check.isSelected()){
            System.out.println("Producto 3 Seleccionado");
            noalcohol.setText("1800");
        }else{
            System.out.println("Producto 3 Deseleccionado");
            noalcohol.setText("0");
        }
    }
    @FXML
    private void click_natural(ActionEvent event) throws Exception {
        if(natural_check.isSelected()){
            System.out.println("Producto 3 Seleccionado");
            natural.setText("1500");
        }else{
            System.out.println("Producto 3 Deseleccionado");
            natural.setText("0");
        }
    }
    @FXML
    private void calculartotal(Event event) throws Exception {
        int calculo=Integer.valueOf(producto1.getText())+Integer.valueOf(producto2.getText())+Integer.valueOf(producto3.getText())+Integer.valueOf(jhonny_plat.getText())+Integer.valueOf(whiskey.getText())+Integer.valueOf(rum.getText())+Integer.valueOf(vodka.getText())+Integer.valueOf(gin.getText())+Integer.valueOf(fruit.getText())+Integer.valueOf(wine.getText())+Integer.valueOf(water.getText())+Integer.valueOf(noalcohol.getText())+Integer.valueOf(natural.getText());
        //System.out.println(producto1.getText());
        total.setText(String.valueOf(calculo));
        
    }
    @FXML
    private void leertag_venta(ActionEvent event) throws Exception {
        System.out.println("You clicked me!");
        Label secondLabel = new Label("Acerque Tag al lector");
                
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
                 
                Scene secondScene = new Scene(secondaryLayout, 250, 100);
 
                Stage secondStage = new Stage();
                secondStage.setTitle("Lector");
                secondStage.setScene(secondScene);
                 
                //Set position of second window, related to primary window.
                
  
                secondStage.show();
        //label.setText("Hello World!");
                Thread.sleep(1000);
        CardTest cardtest = new CardTest();
        uid=cardtest.cardsearch(true);
        if (uid!=""){
            System.out.println("Encontro y cerro ventana");
            secondStage.hide();
            tag_venta.setText(uid);
            //label.setText(uid);
            
            
        }else if(uid!="vacio"){
            
            System.out.println("No encontro y cerro ventana");
            secondStage.hide();
        }
    }
    @FXML
    private void confirmar_venta(ActionEvent event) throws Exception {
        JDBC jdbc = new JDBC();
        int valor=jdbc.descontar_saldo(total.getText(), tag_venta.getText());
        if(valor>=0){
            Label thirdLabel = new Label("Venta realizada saldo es $"+valor);
                
                StackPane thirdLayout = new StackPane();
                thirdLayout.getChildren().add(thirdLabel);
                 
                Scene thirdScene = new Scene(thirdLayout, 250, 100);
 
                Stage thirdStage = new Stage();
                thirdStage.setTitle("Lector");
                thirdStage.setScene(thirdScene);
                 
                //Set position of second window, related to primary window.
                
  
                thirdStage.show();
        }else{
            Label thirdLabel = new Label("Saldo insuficiente");
                
                StackPane thirdLayout = new StackPane();
                thirdLayout.getChildren().add(thirdLabel);
                 
                Scene thirdScene = new Scene(thirdLayout, 250, 100);
 
                Stage thirdStage = new Stage();
                thirdStage.setTitle("Lector");
                thirdStage.setScene(thirdScene);
                 
                //Set position of second window, related to primary window.
                
  
                thirdStage.show();
        }
    }
    @FXML
    private void limpiar_venta(ActionEvent event) throws Exception {
        producto1.setText("0");
        producto2.setText("0");
        producto3.setText("0");
        jhonny_plat.setText("0");
        whiskey.setText("0");
        rum.setText("0");
        vodka.setText("0");
        gin.setText("0");
        fruit.setText("0");
        wine.setText("0");
        water.setText("0");
        noalcohol.setText("0");
        natural.setText("0");
        total.clear();
        tag_venta.clear();
        if(producto1_check.isSelected()){
            producto1_check.fire();
        }
        if(jhonny_plat_check.isSelected()){
            jhonny_plat_check.fire();
        }
        if(whiskey_check.isSelected()){
            whiskey_check.fire();
        }
        if(rum_check.isSelected()){
            rum_check.fire();
        }
        if(vodka_check.isSelected()){
            vodka_check.fire();
        }
        if(gin_check.isSelected()){
            gin_check.fire();
        }
        if(wine_check.isSelected()){
            wine_check.fire();
        }
        if(fruit_check.isSelected()){
            fruit_check.fire();
        }
        if(water_check.isSelected()){
            water_check.fire();
        }
        if(noalcohol_check.isSelected()){
            noalcohol_check.fire();
        }
        if(natural_check.isSelected()){
            natural_check.fire();
        }
        if(producto2_check.isSelected()){
            producto2_check.fire();
        }
        if(producto3_check.isSelected()){
            producto3_check.fire();
        }
        
    }
    @FXML
    private void leertagregistro(ActionEvent event) throws Exception {
        System.out.println("You clicked me!");
        Label secondLabel = new Label("Acerque Tag al lector");
                
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
                 
                Scene secondScene = new Scene(secondaryLayout, 250, 100);
 
                Stage secondStage = new Stage();
                secondStage.setTitle("Lector");
                secondStage.setScene(secondScene);
                 
                //Set position of second window, related to primary window.
                
  
                secondStage.show();
        //label.setText("Hello World!");
                Task<Integer> task;
                task = new Task<Integer>(){
                    @Override protected Integer call() throws Exception{
        //                int iterations;
        //                for(iterations = 0; iterations < 10; iterations++){
        //                    if(isCancelled()){
        //                        break;
        //                    }
        //                    System.out.println("Iteration " + iterations);
        //                    Thread.sleep(3000);
        //                }
        //                return iterations;
                        CardTest cardtest = new CardTest();
                        uid=cardtest.cardsearch(true);
                        if (!"".equals(uid)){
                            System.out.println("Encontro y cerro ventana");
                            //Thread.sleep(3000);

                            //label.setText(uid);
                            Platform.runLater(() -> {
                                secondStage.hide();
                                tagtext2.setText(uid.trim());
                            });

                        }else if(!"vacio".equals(uid)){

                            System.out.println("No encontro y cerro ventana");
                            secondStage.hide();
                        }
                        return 1;
                    }
                };

                //start the background task
                Thread th = new Thread(task);
                th.setDaemon(true);
                System.out.println("Starting background task...");
               th.start();
               System.out.println("Background task started...");
    }
    @FXML
    private void guardaregistro(ActionEvent event) throws Exception{
        JDBC guardar = new JDBC();
        guardar.guarda_registro(nombrereg.getText(), apellidoreg.getText(), emailreg.getText(), telefonoreg.getText(), tagtext2.getText());
        System.out.println("Guardado");
    }
    @FXML
    private void limpiar_reg(ActionEvent event) throws Exception {
        tagtext2.clear();
        nombrereg.clear();
        apellidoreg.clear();
        telefonoreg.clear();
        emailreg.clear();
        //saldoreg.clear();
    }
    @FXML
    private void limpiar_read(ActionEvent event) throws Exception {
        tagtext1.clear();
        nombreread.clear();
        apellidoread.clear();
        telefonoread.clear();
        emailread.clear();
        saldoread.clear();
        imagen.setImage(null);
    }
    @FXML
    private void limpiar_sal(ActionEvent event) throws Exception {
        tagtext3.clear();
        
        saldoreg.clear();
    }
    @FXML
    private void leertagsaldo(ActionEvent event) throws Exception {
        System.out.println("Leer saldo!");
        Label secondLabel = new Label("Acerque Tag al lector");
                
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
                 
                Scene secondScene = new Scene(secondaryLayout, 200, 100);
 
                Stage secondStage = new Stage();
                secondStage.setTitle("Lector");
                secondStage.setScene(secondScene);
                 
                //Set position of second window, related to primary window.
                
  
                secondStage.show();
//        //label.setText("Hello World!");
//                Thread.sleep(1000);
        
        Task<Integer> task;
        task = new Task<Integer>(){
            @Override protected Integer call() throws Exception{
//                int iterations;
//                for(iterations = 0; iterations < 10; iterations++){
//                    if(isCancelled()){
//                        break;
//                    }
//                    System.out.println("Iteration " + iterations);
//                    Thread.sleep(3000);
//                }
//                return iterations;
                CardTest cardtest = new CardTest();
                uid=cardtest.cardsearch(true);
                if (!"".equals(uid.trim())){
                    System.out.println("Encontro y cerro ventana");
                    //Thread.sleep(3000);
                    
                    //label.setText(uid);
                    Platform.runLater(() -> {
                        secondStage.hide();
                        tagtext3.setText(uid.trim());
                    });
                    
                }else if(!"vacio".equals(uid.trim())){

                    System.out.println("No encontro y cerro ventana");
                    secondStage.hide();
                }
                return 1;
            }
        };

        //start the background task
        Thread th = new Thread(task);
        th.setDaemon(true);
        System.out.println("Starting background task...");
       th.start();
       System.out.println("Background task started...");
       
        
    }
    @FXML
    private void click_listaproducto(MouseEvent click) throws Exception {
        if (click.getClickCount() == 2) {
            //Use ListView's getSelected Item
            
            String valor;
            int valor2;
            Productos currentItemSelected;
            currentItemSelected = tabla_prod.getSelectionModel()
                    .getSelectedItem();
            ObservableList<Productos> data = tabla_venta.getItems();
            data.add(currentItemSelected);
            suma=0;
            data = tabla_venta.getItems();
            for(Productos c : data){
            valor = c.getProductValue();
            valor2 = Integer.parseInt(valor);
            suma = suma + valor2;
        }
            
            total_venta.setText(Integer.toString(suma));
            
            System.out.println(currentItemSelected);
            //List<String> values;
            //values = Arrays.asList(currentItemSelected.toString());
            //lista_venta.setItems(FXCollections.observableList(values));
            //tabla_venta.setItems(currentItemSelected);
            
    }
    }
    @FXML
    private void click_listaventa(MouseEvent click) throws Exception {
        if (click.getClickCount() == 2) {
            //Use ListView's getSelected Item
            String valor;
            int valor2;
            Productos currentItemSelected;
            currentItemSelected = tabla_venta.getSelectionModel()
                    .getSelectedItem();
            
            ObservableList<Productos> data = tabla_venta.getItems();
            data.remove(currentItemSelected);
            suma=0;
            for(Productos c : data){
            valor = c.getProductValue();
            valor2 = Integer.parseInt(valor);
            suma = suma + valor2;
        }
            int saldotag,venta,saldoventa;
            total_venta.setText(Integer.toString(suma));
            //saldotag=java.lang.Integer.
            
            System.out.println(currentItemSelected);
            //List<String> values;
            //values = Arrays.asList(currentItemSelected.toString());
            //lista_venta.setItems(FXCollections.observableList(values));
            
            
    }
    }
    @FXML
    private void leertagventa(ActionEvent event) throws Exception {
        System.out.println("Leer saldo!");
        Label secondLabel = new Label("Acerque Tag al lector");
                
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
                 
                Scene secondScene = new Scene(secondaryLayout, 200, 100);
 
                Stage secondStage = new Stage();
                secondStage.setTitle("Lector");
                secondStage.setScene(secondScene);
                 
                //Set position of second window, related to primary window.
                
  
                secondStage.show();
//        //label.setText("Hello World!");
//                Thread.sleep(1000);
        
        Task<Integer> task;
        task = new Task<Integer>(){
            @Override protected Integer call() throws Exception{
//                int iterations;
//                for(iterations = 0; iterations < 10; iterations++){
//                    if(isCancelled()){
//                        break;
//                    }
//                    System.out.println("Iteration " + iterations);
//                    Thread.sleep(3000);
//                }
//                return iterations;
                CardTest cardtest = new CardTest();
                uid=cardtest.cardsearch(true);
                if (!"".equals(uid.trim())){
                    System.out.println("Encontro y cerro ventana");
                    //Thread.sleep(3000);
                    
                    //label.setText(uid);
                    Platform.runLater(() -> {
                        secondStage.hide();
                        text_tagventa.setText(uid.trim());
                        JDBC jdbc = new JDBC();
                        if(jdbc.buscartag(uid.trim())==0){
                            System.out.println("tag no encontrado");
                            
                        }else if(jdbc.buscartag(uid.trim())==1){
                        int venta,saldotag,saldoventa;
                        text_saldotag.setText(jdbc.getsaldo());
                        saldotag= Integer.parseInt(text_saldotag.getText());
                        venta= Integer.parseInt(total_venta.getText());
                        saldoventa=saldotag-venta;
                        text_saldoventa.setText(Integer.toString(saldoventa));
                        
                        
                    }
                    });
                    
                }else if(!"vacio".equals(uid.trim())){

                    System.out.println("No encontro y cerro ventana");
                    secondStage.hide();
                }
                return 1;
            }
        };

        //start the background task
        Thread th = new Thread(task);
        th.setDaemon(true);
        System.out.println("Starting background task...");
       th.start();
       System.out.println("Background task started...");
       
        
    }
    //@Override
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      // List<String> values = Arrays.asList("Producto 1", "Producto 2", "Producto 3","Producto 4","Producto 5","Producto 6");
       //prod=FXCollections.observableArrayList(values);
       //lista_prod.setItems(FXCollections.observableList(prod));
       //lista_prod.setAll(values);
       //List<String> categorias = Arrays.asList("Categoria 1", "Categoria 2", "Categoria 3");
       //tabla_producto1 = new TableColumn("Productos");
        saldoread.setVisible(false);
        
       //tabla_producto1.setCellValueFactory(new PropertyValueFactory<Productos, String>("productName"));
       //tabla_producto1.setCellValueFactory(new PropertyValueFactory<>("productName"));
       //tabla_precio1 = new TableColumn("Precio");
       //tabla_precio1.setCellValueFactory(new PropertyValueFactory<Productos, String>("productValue"));
       //tabla_producto2.setCellValueFactory(new PropertyValueFactory<Productos, String>("productName"));
       //tabla_precio2.setCellValueFactory(new PropertyValueFactory<Productos, String>("productValue"));
       //combo_categoria.setItems(FXCollections.observableList(categorias));
       //lista_venta.setItems(venta);
       //System.out.println(datos.get(0).getProductName());
       //tabla_prod.setItems(datos);
       //tabla_venta.setItems(datos2);
       //tabla_prod.getItems().setAll(datos);
       //tabla_venta.setItems(datos);
      // tabla_prod.getColumns().addAll(tabla_producto1, tabla_precio1);
       //tabla_producto1.se
    }    
    
}
