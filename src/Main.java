import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 20464654j on 01/02/17.
 */
public class Main {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        System.out.println( "Introdueix la ip on revisar els ports oberts..." );
        System.out.println( "A l'aula sera 172.31.numAula.numPC" );
        String ip = in.nextLine();
        int quantSockets = 65535;

        for (int port = 0; port < quantSockets; port++) {


            try{

                //Socket TCP
                Socket cliente = new Socket();

                InetSocketAddress addr = new InetSocketAddress(ip, port);
                // 172.31.numAula.numPC

                // localhost = 127.0.0.1

                //Y asi se establece la conexion
                cliente.connect( addr );

                //Canales de entrada y salida
                OutputStream os = cliente.getOutputStream();

                String mensaje = "Hola!";

                os.write( mensaje.getBytes() );

                System.out.println("el puerto " + port + " esta abierto");

                cliente.close();


            }catch ( IOException e){
            }

        }

    }
}
