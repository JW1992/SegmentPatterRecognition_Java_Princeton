import java.util.*;

public class FastCollinearPoints {
	private int nNumSegs = 0;
	LineSegment[] array;
	List<LineSegment> list = new ArrayList<LineSegment>();
   	public FastCollinearPoints(Point[] points)     // finds all line segments containing 4 or more points
   	{
   		if(points==null) throw new IllegalArgumentException("Input array cannot be null");
   		for(Point p:points)
   			if(p==null) throw new IllegalArgumentException("Input point cannot be null");
   			
   			
   		int nPoints = points.length;
   		for(Point ptTemp : points)
   		{
   			Point[] copy = copy(points);
   			Arrays.sort(copy, ptTemp.slopeOrder());
   			double[] fSlopes = new double[nPoints];
   			int nNumSameSlopes=1;
   			fSlopes[0] = ptTemp.slopeTo(copy[0]);
   			for(int j=1; j<nPoints; j++)
   			{
   				fSlopes[j] = ptTemp.slopeTo(copy[j]);
   				if(fSlopes[j]==fSlopes[j-1]) nNumSameSlopes++;
   				else
   				{
   					if(nNumSameSlopes>=3)
   					{
   						Point[] pTemp = new Point[nNumSameSlopes+1];
   						pTemp[0] = ptTemp;
   						for(int m=1; m<=nNumSameSlopes; m++) pTemp[m] = copy[j-m];
   						Arrays.sort(pTemp);
   						if(pTemp[0]==ptTemp)
   						{
   							nNumSegs++;
   							list.add(new LineSegment(pTemp[0], pTemp[nNumSameSlopes]));
   						}
   					}
   					nNumSameSlopes = 1;
   				}
   			}
   		}
   		array = list.toArray(new LineSegment[nNumSegs]);
   		
   		
   		
   	}
   	private static Point[] copy(Point[] points) {
        Point[] copy = new Point[points.length];
        for (int i = 0; i < points.length; i++) copy[i] = points[i];

        return copy;
    }
   	public int numberOfSegments()        // the number of line segments
   	{
   		return nNumSegs;
   	}
   	public LineSegment[] segments()                // the line segments
   	{
   		return array;
   	}
}
