/*
Name: Zhou, Albert
Email: azhou2@lsu.edu
Project: PA-2 
Instructor: Feng Chen
Class: cs4103-sp23
Login ID: cs410388
 */
import java.io.*;
import java.util.*;

public class Clock {
	public static void main(String[] args) throws Exception {
		circularList<pageFrame> frames = new circularList<pageFrame>();
		List<trace> traceFile = new ArrayList<trace>();
		pageFrame clockHand = new pageFrame();
		trace t = new trace();
		int refNum = 0;
		int faultNumR = 0;
		int faultNumW = 0;
		if(args.length!=5) {
			System.out.println("5 args needed");
			System.exit(-1);
		}
		FileReader f = new FileReader(args[3]);
		Scanner sc = new Scanner(f);
		while(sc.hasNextLine()) {
			String[] line = sc.nextLine().trim().split("\\s+");
			pageFrame p = new pageFrame(line[0],line[1],"1");
			int n=0;
			boolean findHit = false;
			int s = frames.size();
			while(n<s) {
				if(line[1].equals(clockHand.getPageNum())) {
					clockHand.setRB("1");
					clockHand.setMB(line[0]);
					t=new trace(line[0],line[1],"H","-1","0","0");
					traceFile.add(t);
					findHit = true;
					break;
				}
				else {
					frames.rotateClockwise();
					clockHand=frames.front();
					n++;
				}
			}
			if(!findHit) {
				if(frames.size()<Integer.parseInt(args[0])) {
					t=new trace(line[0],line[1],"F","-1",args[1],"0");
					frames.add(p);
					traceFile.add(t);
					clockHand = frames.front();
				}
				else if(frames.size()==Integer.parseInt(args[0])) {
					while(clockHand.getRB().equals("1")) {
						clockHand.setRB("0");
						frames.rotateClockwise();
						clockHand=frames.front();
					}
					if(clockHand.getRB().equals("0")) {
						if(clockHand.getMB().equalsIgnoreCase("W")) {
							t = new trace(line[0],line[1],"F",clockHand.getPageNum(),args[1],args[2]);
						}
						if(clockHand.getMB().equalsIgnoreCase("R")) {
							t = new trace(line[0],line[1],"F",clockHand.getPageNum(),args[1],"0");
						}
						traceFile.add(t);
						clockHand.frameReplace(p);
					}
					frames.rotateClockwise();
					clockHand=frames.front();
				}
					if(line[0].equalsIgnoreCase("R")) {
						faultNumR++;
					}
					else if(line[0].equalsIgnoreCase("W")) {
						faultNumW++;
					}
				}
				refNum++;
			}
			sc.close();
			int inTime = 0;
			int outTime = 0;
			for(trace tt: traceFile) {
				System.out.println(tt.toString());
				inTime += Integer.parseInt(tt.getInTime());
				outTime += Integer.parseInt(tt.getOutTime());
			}
			System.out.println("total number of page reference: "+refNum);
			System.out.println("total number of fault on read pages: "+faultNumR);
			System.out.println("total number of fault on write pages: "+faultNumW);
			System.out.println("total number of time units for swap in: "+inTime);
			System.out.println("total number of time units for swap out: "+outTime);
			PrintStream o = new PrintStream(new File(args[4]));
			System.setOut(o);
			for(trace tt: traceFile) {
				System.out.println(tt.toString());
				inTime += Integer.parseInt(tt.getInTime());
				outTime += Integer.parseInt(tt.getOutTime());
			}
			System.out.println("total number of page reference: "+refNum);
			System.out.println("total number of fault on read pages: "+faultNumR);
			System.out.println("total number of fault on write pages: "+faultNumW);
			System.out.println("total number of time units for swap in: "+inTime);
			System.out.println("total number of time units for swap out: "+outTime);

	}

}
