import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    public void cria(InputStream fileInputStream, String NomeArquivo) throws Exception {
            // Ler a imagem
            //FileInputStream fileInputStream = new FileInputStream(new File("D:/Aulas de JAVA/ImersaoJAVA/Aula 2/Projeto 2/GeradoraDeFigurinhas/Images/Filme.jpg"));
            //InputStream fileInputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
            BufferedImage ImagemOriginal = ImageIO.read(fileInputStream);

            // Cria nova imagem em memória com transparênca e com tamanho desejado
            int Largura = ImagemOriginal.getWidth();
            int Altura = ImagemOriginal.getHeight();
            int NovaAltura = Altura + 200;
            BufferedImage NovaImagem = new BufferedImage(Largura, NovaAltura, BufferedImage.TRANSLUCENT);

            // Copiar a imagem original para nova imagem (em memória)            
            Graphics2D Graphics = (Graphics2D) NovaImagem.getGraphics();
            Graphics.drawImage(ImagemOriginal, 0, 0, null);

            // Configurar a fonte
            var Fonte = new Font(Font.SANS_SERIF, Font.BOLD, 80);
            Graphics.setColor(Color.GREEN);
            Graphics.setFont(Fonte);

            // Escrever uma frase na nova imagem
            Graphics.drawString("TOPZERA", 180, NovaAltura - 100);
            
            // Salvar a nova imagem com outro nome
            NomeArquivo = NomeArquivo.replaceAll("\\:", "_");

            String PathName = "D:/Aulas de JAVA/ImersaoJAVA/Aula 2/Projeto 2/GeradoraDeFigurinhas/Figurinhas/" + NomeArquivo + ".png";
            ImageIO.write(NovaImagem, "png", new File(PathName));
    }
}