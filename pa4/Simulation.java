/* This is the final Simulation.java
 * Simulation.java
 * Programmer: Tiancheng Fu
 * CMPS 12B
 * Date: August 7th, 2018
 * Cruzid: tfu6
 * Programming Assignment 4
 * The Simulation.java read two user input, one given a batch of m jobs from the input file, another 
 * one given a outputfile. The each input job with specific arrival times anddurations, determine the 
 * total wait time, the maximum wait time and the average wait time over all m jobs.
 * Furthermore, determine these quantities for n processors, where n ranges from 1 to number of jobs-1.
 */
import java.io.*;
import java.util.Scanner;

public class Simulation{

//-----------------------------------------------------------------------------
//
// The following function may be of use in assembling the initial backup and/or
// storage queues.  You may use it as is, alter it as you see fit, or delete it
// altogether.
//
//-----------------------------------------------------------------------------

   public static Job getJob(Scanner in) {
      String[] s = in.nextLine().split(" ");
      int a = Integer.parseInt(s[0]);
      int d = Integer.parseInt(s[1]);
      return new Job(a, d);
   }

//-----------------------------------------------------------------------------
//
// The following stub for function main contains a possible algorithm for this
// project.  Follow it if you like.  Note that there are no instructions below
// which mention writing to either of the output files.  You must intersperse
// those commands as necessary.
//
//-----------------------------------------------------------------------------

   public static void main(String[] args) throws IOException{
     
     //Decalare variables that used in the program
     Scanner in = null;
     PrintWriter out = null;
     String line = null;
     Job [] job = null;
     
     int numJob = 0;//number of jobs
     int numPro = 0;//number of processes been passed
     int b;
     
     String [] token = null;
     
//    1.  check command line arguments
     if(args.length < 1){
       System.out.println("Usage: FileCopy <input file>");
       System.exit(1);
     }
//
//    2.  open files for reading and writing
      in = new Scanner(new File(args[0]));
      out = new PrintWriter(new FileWriter(args[0]+".trc")); //.trc writer
      
      out.println("Trace file: " +args[0]+".trc");
      
//    3.  read in m jobs from input file
     int c = 0;
     while(in.hasNextLine()){
        
        line = in.nextLine().trim() + " ";
        token = line.split("\\s+");
        b = token.length;   
        //System.out.println(b);
        if((b<2)&&(b!=0)){
          numJob = Integer.valueOf(token[0]);
          job = new Job[numJob];
          
         }else if(b!=0){
          job[c] = new Job(Integer.valueOf(token[0]),Integer.valueOf(token[1]));
          c++;
        }
        
     }
     
     int n = numJob-1;
     int [] totalWait = new int [n];
     int [] maxWait = new int [n];
     
     double [] averageWait = new double [n];
     out.println(numJob+" Jobs");
     
   for(int i=0; i<numJob;i++){
      out.print(job[i].toString()+" ");
    }
      out.println("\n");

//    4.  run simulation with n processors for n=1 to n=m-1  {
     for(int i=1; i <= n; i++){
      out.println("*****************************");
      out.println(i+" processor: ");
      out.println("*****************************");
      
       numPro++;
       int time=0;
//    5.  declare and initialize an array of n processor Queues and any 
//        necessary storage Queues
       Queue qWait = new Queue(); //The queue stored all of the jobs that have finished the process and not yet get put into the processors (queue 0:)
       Queue [] q = new Queue[i]; //The processor queues
       
       //Initializing the processor queues
       for(int j=0;j<i;j++){
         q[j]=new Queue();  
       }
       
       boolean [] s = new boolean[n]; //switch use to end the processing with a number of processors and switch to process with another number of process
       
       int [] timeA = new int[numJob]; //integer array use to store the Arrival Times for the jobs
       int [] timeD = new int[numJob]; //integer array use to store the Duration Times for the jobs
       int [] timeF = new int[numJob]; //integer array use to store the Finish Times for the jobs
       int [] timeW = new int[numJob]; //integer array use to store the Wait Times for the jobs
       
       int count = 0; //integer variable use to count the number of jobs been finished and store their datas into time arrays
       int qIndex = 0; //integer variable use to store the index of processor queue
       //int [] f = new int [n];
       
       // Insert all of the jobs into qWait and store all of their Duration times and Arrival times into arrays
       for(int j=0; j<numJob;j++){
         qWait.enqueue(job[j]);
         timeA[j]=job[j].getArrival();
         timeD[j]=job[j].getDuration();
         //timeF[j]=timeA[j]+timeD[j];
       }
        
//    6.  while unprocessed jobs remain  {
        while(s[i-1] == false){
//    7.  determine the time of the next arrival or finish event and 
//        update time
          boolean sNext = false;//determine if there is another job with same time
         boolean sTime = false;//Caluating the times which have print out
//    8.  complete all processes finishing now
          if(time > timeA[0]){
           for(int j=0;j<i;j++){
             if(q[j].length()!=0){
             if(time == ((Job)q[j].peek()).getFinish()){
               qWait.enqueue(q[j].dequeue());
               sTime = true;
               if(q[j].length()!=0 && time == ((Job)q[j].peek()).getFinish()){
                 //System.out.println("sNext1");
                 sNext = true;
               }
             }
            }
           }
          }
          //count++;
//    9.  if there are any jobs arriving now, assign them to a processor 
//        Queue of minimum length and with lowest index in the queue array.
 
         if(qWait.length()!=0 && (time == ((Job)qWait.peek()).getArrival())){
             int shortI = 0;
             sTime = true;
           for(int j=0;j<i;j++){
             if(q[j]!=null&&q[shortI]!=null){
             if(q[j].length()<q[shortI].length()){
               shortI = j;
             }
            }
           }
           Job newJ = (Job)(qWait.dequeue());
          if(qWait.length()!=0 && time==((Job)qWait.peek()).getArrival()){
            //System.out.println("sNext2");
             sNext=true;
           }
           
           if(q[shortI].length()<1){
           newJ.computeFinishTime(time);
           timeW[count]=newJ.getWaitTime();
           count++;
           q[shortI].enqueue(newJ);
           }else{
           q[shortI].enqueue(newJ);
          }

         }
        //Compute the Finish Time of the next job in the processor when the last job has finished
        int UNDEF = -1;
        for(int j=0;j<i;j++){
          if(q[j].length()!=0 && (((Job)q[j].peek()).getFinish() == UNDEF)){
            ((Job)q[j].peek()).computeFinishTime(time);
            timeW[count]=((Job)q[j].peek()).getWaitTime();
            count++;
            sTime = true;
           }
         }
        
        //If there is new job arrives or job got finished, output the current jobs in the processors into the .trc file
        if(sNext == true){
         sTime = false;
        }
         //Print out the .trc file
         if(sTime == true ||time == 0){
           out.println("time ="+time);
           out.println("0: "+qWait.toString());
           //out.print(qWait.toString());
           
           for(int j=0;j<i;j++){
             out.print((j+1)+": ");
             if(q[j]!=null){
             out.print(q[j].toString()+"\n");
          }
         }
           out.println("");
        } 
       //If there is no jobs arrive or finish in the same time then add 1 to time
       if(sNext == false){
         time++;
       }
       
       /*if(time == 30){
       s[i-1]=false;
       break;
       }*/
    //If all jobs have been finished with the current number of processors then switch to processing jobs with one more processor
    for(int j=0;j<i;j++){
     if(q[j].length()!=0 ||time < timeA[0]){
      s[i-1] = false;
      break;
     }else if(qWait.length()==numJob && time > timeA[0]){
       s[i-1] = true; 
     }
   }
   //System.out.println(time);

//    10.     } end loop
      }
//    11.  compute the total wait, maximum wait, and average wait for 
//         all Jobs, then reset finish times
        
            maxWait[i-1] = timeW[0];
            
           for(int k=0;k<numJob;k++){
             totalWait[i-1] = totalWait[i-1]+timeW[k];
             if(timeW[k]>maxWait[i-1]){
              maxWait[i-1] = timeW[k];
             }
            }
             double tWait = totalWait[i-1];
             averageWait[i-1] = Math.round((tWait/numJob) * 100.0) / 100.0;
           //reset finish times
           for(int j=0;j<numJob;j++){
            job[j].resetFinishTime(); 
          }
        
//    12. } end loop
      }
    
    out.close();// close output for the .trc file
    
    //Print out the .rpt file
    PrintWriter out2 = new PrintWriter(new FileWriter(args[0]+".rpt"));
    out2.println("Report file: "+args[0]+".rpt");
    out2.println(numJob+" Jobs:");
     for(int i=0; i<numJob;i++){
         out2.print(job[i].toString()+" ");
      }
    out2.println("\n");
    out2.println("*****************************");
     for(int i=0; i<n; i++){
        out2.print((i+1)+" processor: totalWait="+totalWait[i]+", maxWait="+maxWait[i]+", averageWait="+averageWait[i]+"\n");
     }
     
//    13. close input and output for the .rpt file
   in.close();
   out2.close();
 }
}
