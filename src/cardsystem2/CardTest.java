package cardsystem2;

import java.util.*;
import javax.smartcardio.*;

public class CardTest {

  final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
  CardTerminal terminal;
  public static String bytesToHex(byte[] bytes) {
    char[] hexChars = new char[bytes.length * 2];
    int v;
    for ( int j = 0; j < bytes.length-2; j++ ) {
      v = bytes[j] & 0xFF;
      hexChars[j * 2] = hexArray[v >>> 4];
      hexChars[j * 2 + 1] = hexArray[v & 0x0F];
    }
    return new String(hexChars);
  }
  public CardTest() throws Exception {
      TerminalFactory factory = TerminalFactory.getInstance("PC/SC", null);
    System.out.println(factory);

    List<CardTerminal> terminals = factory.terminals().list();
    System.out.println("Terminals: " + terminals);
    if (terminals.isEmpty()) {
      throw new Exception("No card terminals available");
    }

    this.terminal = terminals.get(0);
      
  }
 
    
      
    // Keep looping looking for cards until the application is closed
    
    public String cardsearch (boolean flag) throws Exception {
        int contador=0;
        while( flag )
    {
      this.terminal.waitForCardPresent( 0 );
      try {
        Card card = terminal.connect("*");
        CardChannel channel = card.getBasicChannel();

        CommandAPDU command = new CommandAPDU(new byte[]{(byte)0xFF,(byte)0xCA,(byte)0x00,(byte)0x00,(byte)0x00});
        ResponseAPDU response = channel.transmit(command);

        byte[] byteArray = response.getBytes();
        System.out.println( bytesToHex( byteArray ) );
        //Thread.sleep(1000);
        if (!"".equals(bytesToHex(byteArray))){
            System.out.println("funciono");
            return bytesToHex(byteArray);
            //flag=false;
            
      }
            
       System.out.println(contador);     
       contador=contador+1;
        if(contador==5){
            flag=false;
            
        }
      } catch (CardException e) {
      }
    }
        return "vacio";
        
      
    } 
}