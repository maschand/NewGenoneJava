package com.newgen.iforms.user.BNIAccountOpeningChan;

import com.newgen.ApplicationLogger;
import com.newgen.iforms.EControl;
import com.newgen.iforms.FormDef;
import com.newgen.iforms.custom.IFormCustomHooks;
import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.custom.IFormServerEventHandler;
import com.newgen.json.JSONObject;
import com.newgen.webclientcodebase.model.WorkdeskModel;
import java.io.File;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import com.newgen.commonlogger.NGLogger;

public class CustomCodeHandler extends IFormCustomHooks implements IFormServerEventHandler {
  public void beforeFormLoad(FormDef formdef, IFormReference iformRef) {}
  
  public String executeCustomService(FormDef formdef, IFormReference iformRef, String selectedInputXML, String controlName, String evtType) {
      
    // preprocesssing  
      
   String xml = "<input1>data</input1><input2>data2</input2>";   
   
   // call client webservice
   //post processsing
   String output = "<PersonalDetails>\n" +
"	<EmpName>xyz</EmpName>\n" +
"	<EmpAge>abc</EmpAge>\n" +
"</PersonalDetails>	";
   
   return output;
  }
  
  public JSONArray executeEvent(FormDef formdef, IFormReference iformRef, String arg2, String arg3) {
    return null;
  }
  
  public String generateHTML(EControl econtrol) {
      
    String id = econtrol.getControlId();
   
   if( id.equals("card_alternate")){
    return "<div style='' onclick='func1()'></div>";
   }
   else
       return "<div></div>";
  }
  
  public String getCustomFilterXML(FormDef formdef, IFormReference iformRef, String arg2) {
    return null;
  }
  
  public boolean introduceWorkItemInSpecificProcess(IFormReference formdef, String arg1) {
    return false;
  }
  
  public String introduceWorkItemInWorkFlow(IFormReference iformRef, HttpServletRequest arg1, HttpServletResponse arg2) {
    return null;
  }
  
 public static String encrypt(String strToEncrypt) {
   return strToEncrypt;
  }
  
  public String introduceWorkItemInWorkFlow(IFormReference iformRef, HttpServletRequest arg1, HttpServletResponse arg2, WorkdeskModel arg3) {
         
    return null;
  }
  
  public String onChangeEventServerSide(IFormReference iformRef, String arg1) {
    return null;
  }
  
  public String postHookExportToPDF(IFormReference iformRef, File arg1) {
    return null;
  }
  
  public void postHookOnDocumentUpload(IFormReference iformRef, String arg1, String arg2, File arg3, int arg4) {}
  
  public String setMaskedValue(String ctrlName, String arg1) {
    return arg1;
  }
  
  public void updateDataInWidget(IFormReference iformRef, String arg1) {}
  
  public String validateDocumentConfiguration(String id, String arg1, File arg2, Locale arg3) {
    return null;
  }
  
  public boolean validateWidget( IFormReference iformRef, String formName ) {
      if( formName == "sdfhids")
    return false;
      
      return true;
  }
  
  public JSONArray validateSubmittedForm(FormDef formdef, IFormReference iformRef, String arg2) {
    return null;
  }
  
  public String executeServerEvent(IFormReference ifr, String ctrlName, String eventType, String data) {
      
	  NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), "Welcome to bni App Chand");
	  
	  String name = (String) "Welcome to bni App " + ifr.getControlValue("FullName");
      
	  NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), name);
	  return "";
  }
  
  public void postHookOnDocumentOperations(IFormReference objReference, String controlId, String docType, int docImageIndex, String operationType) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
