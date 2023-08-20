/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Collections9.java,v 1.1 2006/04/21 17:14:26 livshits Exp $
 */
package securibench.micro.collections;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import securibench.micro.BasicTestCase;
import securibench.micro.MicroTestCase;

/** 
 *  @servlet description = "more complex collection copying" 
 *  @servlet vuln_count = "0" 
 *  */
public class Collections9 extends BasicTestCase implements MicroTestCase {
    private static final String FIELD_NAME = "name";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String s1 = req.getParameter(FIELD_NAME);
        LinkedList c1 = new LinkedList();
        c1.addLast(s1);
        ArrayList c2 = new ArrayList();
        c2.add("abc");
        c2.retainAll(c1);
        String s2 = (String) c2.get(0); 
        
        PrintWriter writer = resp.getWriter();  
        writer.println(s2);                    /* OK */
    }
    
    public String getDescription() {
        return "more complex collection copying";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}