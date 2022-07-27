import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception { // Método principal
        // fazer uma conexão HTTP e buscar os top 250 filmes
        //String url = "https://imdb-api.com/en/API/Top250Movies/k_beojdf0c";
        String url = "https://alura-filmes.herokuapp.com/conteudos";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // filtrar/parsear os dados úteis (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        //System.out.println(listaDeFilmes.size());

        // exibir e manipular os dados
        var geradora = new GeradoraDeFigurinhas();
        for (Map<String,String> filme : listaDeFilmes) {
            try{
                String URLImagem = filme.get("image");
                URLImagem = URLImagem.substring(0, URLImagem.length()-32) + ".jpg";
                String Title = filme.get("title");
                //String Rating = filme.get("imDRating"); 
                
                System.out.println(Title);
                System.out.println(URLImagem);

                InputStream fileInputStream = new URL(URLImagem).openStream();
                String NomeArquivo = Title;
                
                geradora.cria(fileInputStream, NomeArquivo);
            }
            catch (Exception e){
                System.out.println("Deu pau aqui:"+filme.get("title"));
            }
        }        
    }
}
