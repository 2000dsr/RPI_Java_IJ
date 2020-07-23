/**
 * For now a frame will just be an id. In the future it will be an actual video frame
 * @author dr
 *
 */
package sample;
import java.awt.Image;
import java.awt.image.BufferedImage;
public class frame {

	public static int CurrId = 1;
	public int id;
	public BufferedImage picture;


	public frame(BufferedImage pic) {
		this.id = CurrId;
		this.picture = pic;
		CurrId ++;
	}

	public String toString() {
		return Integer.toString(this.id);
	}

}

