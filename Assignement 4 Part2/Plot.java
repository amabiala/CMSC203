public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;

	public Plot() {
		x=0;
		y=0;
		width=1;
		depth=1;
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

	public boolean overlaps(Plot plot)
	{
		boolean overlap = false;
		
		if((plot.y < y + depth) && (plot.y + plot.depth > y) && (plot.x < x + width) && (plot.x + plot.width > x))
		{
			overlap = true;
		}
		
		return overlap;
	}

	public boolean encompasses(Plot plot) 
	{
		boolean encompass = false;
		if ((plot.x + plot.width <= x + width) && (plot.y + plot.depth <= y + depth) && (plot.x >= x) && (plot.y >= y))
		{
			encompass = true;
		}
		else
		{
			encompass = false;
		}
		
		return encompass;
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
