import java.io.*;
import java.util.*;

public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;

	public Plot() {
		this(0,0,0,0);
	}

	public Plot(Plot p) {
		this(p.x,p.y,p.width,p.depth);
	}

	public Plot(int x, int y, int width, int depth) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.depth=depth;
	}

	public boolean overlaps(Plot p) {
		if ((p.x+p.width)<=x||(x+width)>=p.x||(y+depth)>=p.y||(p.y+p.depth)<=y) {
		return true;
		}
		else {
			return false;
		}
	}

	public boolean encompasses(Plot p) {
		if ((p.y>=y)&&((p.y+p.depth)<=(y+depth))&&((p.x>=x)&&((p.x+p.width)<=(x+width)))){
			return true;
		}
		else {
			return false;
		}
	}

	public void setX(int x) {
		this.x=x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y=y;
	}

	public int getY() {
		return y;
	}

	public void setWidth(int width) {
		this.width=width;
	}

	public int getWidth() {
		return width;
	}

	public void setDepth(int depth) {
		this.depth=depth;
	}

	public int getDepth() {
		return depth;
	}

	public String toString() {
		return "Upper left: ("+x+", "+y+"); Width: "+width+" Depth: "+depth;
	}

}
