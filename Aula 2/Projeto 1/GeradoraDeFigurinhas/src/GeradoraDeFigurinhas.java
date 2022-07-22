import java.io.File;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Graphics;

public class GeradoraDeFigurinhas {
    public void cria() throws Exception {
            // Ler a imagem
            BufferedImage ImagemOriginal = ImageIO.read(new File("Images/Filme.jpg"));

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
            ImageIO.write(NovaImagem, "png", new File("Figurinhas/NovaFigurinha.png"));        
    }

    public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();
        geradora.cria();        
    }
}