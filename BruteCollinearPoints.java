import java.util.*;
public class BruteCollinearPoints {
	private int nNumSegs = 0;
	List<LineSegment> list = new ArrayList<LineSegment>();
	LineSegment[] array;
   	public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
   	{
   		if(points==null) throw new IllegalArgumentException("Input cannot be null");
   		int nLength = points.length;
   		for(int i=0; i<nLength; i++){
   			for(int j=i+1; j<nLength; j++){
   				for(int m=j+1; m<nLength; m++){
   					for(int n=m+1; n<nLength; n++){
   						if(points[i]==null||points[i]==null||points[i]==null||points[i]==null)
   							throw new IllegalArgumentException("Point cannot be null");
   						if(points[i].compareTo(points[j])==0||points[i].compareTo(points[m])==0||points[i].compareTo(points[n])==0||points[j].compareTo(points[m])==0||points[j].compareTo(points[n])==0||points[m].compareTo(points[n])==0) throw new IllegalArgumentException("Points cannot be same");
   						if(points[i].slopeTo(points[j])==points[j].slopeTo(points[m])&&points[j].slopeTo(points[m])==points[m].slopeTo(points[n])) {
   							List<Point> pTemp = new ArrayList<Point>();
   							pTemp.add(points[i]);
   							pTemp.add(points[j]);
   							pTemp.add(points[m]);
   							pTemp.add(points[n]);
   							Collections.sort(pTemp);
   							list.add(new LineSegment(pTemp.get(0),pTemp.get(3)));
   						}
   					}
   				}
   			}
   		}
   		nNumSegs = list.size();
   		array = list.toArray(new LineSegment[nNumSegs]);
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
