import java.io.*;

//imprimir um arquivo no console
public class CheckedException {
    public static void main(String[] args) {
        String nomeDoArquivo = "fernando-pessoa.txt";

        try {
                imprimirArquivoNoConsole(nomeDoArquivo);
        } catch (FileNotFoundException e) {
            System.out.println("Revise o nome do arquivo que você deseja imprimir! " + e.getCause());
                e.printStackTrace();
        } catch (IOException e){
                //e.printStackTrace();
            System.out.println("Ocorreu um erro inesperado! Entre em contato com o suporte! " + e.getCause());
        } finally {
            System.out.println("Chegou no finally!");
        }

        System.out.println("Apesar da exception ou não, o programa continua...");
    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException {
        File file = new File(nomeDoArquivo);

        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do{
            bw.write(line);
            bw.newLine();
            line=br.readLine();
        } while(line != null);
        bw.flush();
        br.close();
    }

}
