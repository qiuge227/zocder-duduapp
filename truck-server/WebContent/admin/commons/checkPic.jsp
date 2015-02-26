<%@ page contentType="image/jpeg"
 import="java.awt.image.*,
         javax.imageio.*,
         com.truck.util.RandomPic,
         java.io.*"%>
<%
 response.setHeader("Pragma", "No-cache");
 response.setHeader("Cache-Control", "no-cache");
 response.setDateHeader("Expires", 0);
 double rand = Math.random() * 10000;
 RandomPic rp = new RandomPic(Double.toString(rand));
 rp.drawClient();
 session.setAttribute("checkPic", rp.authenticationCode);
 BufferedImage image = rp.image;
 OutputStream output=response.getOutputStream();
 try 
 {
  ImageIO.write(image, "JPEG", output);
 } catch (IOException e) {
  e.printStackTrace();
 }finally{
 	output.flush();
 	output.close();
 	output=null;
 	response.flushBuffer();
 	out.clear();
 	out = pageContext.pushBody();
 }
 
%>
