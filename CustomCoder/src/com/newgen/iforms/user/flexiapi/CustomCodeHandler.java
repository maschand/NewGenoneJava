package com.newgen.iforms.user.flexiapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newgen.ApplicationLogger;
import com.newgen.iforms.EControl;
import com.newgen.iforms.FormDef;
import com.newgen.iforms.custom.IFormCustomHooks;
import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.custom.IFormServerEventHandler;
import com.newgen.json.JSONObject;
import com.newgen.webclientcodebase.model.WorkdeskModel;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import com.newgen.commonlogger.NGLogger;
import com.newgen.iforms.user.flexiapi.*;
import com.newgen.iforms.user.jacksonDatabind.*;

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
	  NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), "\nminerale call api started");
	  ifr.setValue("hit_status", "ON HIT!");


	  DukcapilRequest dukRequest = new DukcapilRequest();
	  DukcapilResponse dukcapilResponse = new DukcapilResponse();
	  
	  String dukcapilResponseJson = "";
	  String hitStatus = "SUCCESS";
	  String errorMsg = "";
	  String auditQueryTemplate = "INSERT INTO DUKCAPIL_AUDIT_TRAIL ("
	  		+ "CREATED_AT, "
	  		+ "CHANNEL_ID, "
	  		+ "NO_KK, "
	  		+ "NIK, "
	  		+ "NAMA_LENGKAP, "
	  		+ "JENIS_KELAMIN,"
	  		+ "TEMPAT_LAHIR, "
	  		+ "TANGGAL_LAHIR, "
	  		+ "STATUS_KAWIN, "
	  		+ "JENIS_PEKERJAAN, "
	  		+ "NAMA_IBU, "
	  		+ "ALAMAT, "
	  		+ "NO_PROVINSI, "
	  		+ "NO_KABUPATEN, "
	  		+ "NO_KECAMATAN, "
	  		+ "NO_KELURAHAN, "
	  		+ "NAMA_PROVINSI, "
	  		+ "NAMA_KABUPATEN, "
	  		+ "NAMA_KELURAHAN, "
	  		+ "RW, "
	  		+ "RT, "
	  		+ "THRESHOLD, "
	  		+ "DUKCAPIL_RESPONSE_JSON, "
	  		+ "HIT_STATUS,"
	  		+ "HIT_ERROR_MSG"
	  		+ ") "
	  		
			+ "VALUES ("
			+ "TIMESTAMP '@CREATED_AT', "
			+ "'@CHANNEL_ID', "
			+ "'@NO_KK', "
			+ "'@NIK', "
			+ "'@NAMA_LENGKAP', "
			+ "'@JENIS_KELAMIN',"
			+ "'@TEMPAT_LAHIR', "
			+ "'@TANGGAL_LAHIR', "
			+ "'@STATUS_KAWIN', "
			+ "'@JENIS_PEKERJAAN', "
			+ "'@NAMA_IBU', "
			+ "'@ALAMAT', "
			+ "'@NO_PROVINSI', "
			+ "'@NO_KABUPATEN', "
			+ "'@NO_KECAMATAN', "
			+ "'@NO_KELURAHAN', "
			+ "'@NAMA_PROVINSI', "
			+ "'@NAMA_KABUPATEN', "
			+ "'@NAMA_KELURAHAN', "
			+ "'@RW', "
			+ "'@RT', "
			+ "'@THRESHOLD', "
			+ "'@DUKCAPIL_RESPONSE_JSON', "
			+ "'@HIT_STATUS'," 
			+ "'@HIT_ERROR_MSG'"
			+ ")";
	  
	  try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
          HttpPost postRequest = new HttpPost("http://192.168.151.220:45106/dukcapil");
          postRequest.setHeader("Content-Type", "application/json");
          
          
//          dukRequest.setChannelId( (String)ifr.getValue("silicon_channel_id") );
//          dukRequest.setNoKK((String)ifr.getValue("silicon_no_kk"));
//          dukRequest.setNik((String)ifr.getValue("silicon_nik"));
//          dukRequest.setNamaLengkap((String)ifr.getValue("silicon_nama_lengkap"));
//          dukRequest.setJenisKelamin((String)ifr.getValue("silicon_jenis_kelamin"));
//          dukRequest.setTempatLahir((String)ifr.getValue("silicon_tempat_lahir"));
//          dukRequest.setTanggalLahir((String)ifr.getValue("silicon_tanggal_lahir"));
//          dukRequest.setStatusKawin((String)ifr.getValue("silicon_status_kawin"));
//          dukRequest.setJenisPekerjaan((String)ifr.getValue("silicon_jenis_pekerjaan"));
//          dukRequest.setNamaIbu((String)ifr.getValue("silicon_nama_ibu"));
//          dukRequest.setAlamat((String)ifr.getValue("silicon_set_alamat"));
//          dukRequest.setNoProvinsi((String)ifr.getValue("silicon_no_provinsi"));
//          dukRequest.setNoKabupaten((String)ifr.getValue("silicon_no_kabupaten"));
//          dukRequest.setNoKecamatan((String)ifr.getValue("silicon_no_kecamatan"));
//          dukRequest.setNoKelurahan((String)ifr.getValue("silicon_no_kelurahan"));
//          dukRequest.setNamaProvinsi((String)ifr.getValue("silicon_nama_provinsi"));
//          dukRequest.setNamaKabupaten((String)ifr.getValue("silicon_nama_kabupaten"));
//          dukRequest.setNamaKecamatan((String)ifr.getValue("silicon_nama_kecamatan"));
//          dukRequest.setNamaKelurahan((String)ifr.getValue("silicon_nama_kelurahan"));
//          dukRequest.setRw((String)ifr.getValue("silicon_rw"));
//          dukRequest.setRt((String)ifr.getValue("silicon_rt"));
//          dukRequest.setThreshold((String)ifr.getValue("silicon_threshold"));
          
          //Request
          dukRequest.setChannelId( (String)"DIGILOAN" );
          dukRequest.setNoKK((String)"");
          dukRequest.setNik((String)"6171042006940009");
          dukRequest.setNamaLengkap((String)"DODDI ARIA PUTRA");
          dukRequest.setJenisKelamin((String)"LAKI-LAKI");
          dukRequest.setTempatLahir((String)"");
          dukRequest.setTanggalLahir((String)"20-06-1994");
          dukRequest.setStatusKawin((String)"");
          dukRequest.setJenisPekerjaan((String)"");
          dukRequest.setNamaIbu((String)"");
          dukRequest.setAlamat((String)"");
          dukRequest.setNoProvinsi((String)"");
          dukRequest.setNoKabupaten((String)"");
          dukRequest.setNoKecamatan((String)"");
          dukRequest.setNoKelurahan((String)"");
          dukRequest.setNamaProvinsi((String)"");
          dukRequest.setNamaKabupaten((String)"");
          dukRequest.setNamaKecamatan((String)"");
          dukRequest.setNamaKelurahan((String)"");
          dukRequest.setRw((String)"");
          dukRequest.setRt((String)"");
          dukRequest.setThreshold((String)"90");
          
          
          ObjectMapper mapper = new ObjectMapper();
          String jsonInputString = mapper.writeValueAsString(dukRequest);
          
          StringEntity entity = new StringEntity(jsonInputString);
          postRequest.setEntity(entity);
          
          NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), "proceed to hit API ");
          
          try (CloseableHttpResponse response = httpClient.execute(postRequest)) {
        	  int statusCode = response.getStatusLine().getStatusCode();
              NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), "Response Code: " + statusCode);
              
              String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
              
              dukcapilResponseJson = responseString;
              
              NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), responseString);
              ObjectMapper objectMapper = new ObjectMapper();
              dukcapilResponse = objectMapper.readValue(responseString, DukcapilResponse.class);
              
              NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), "dukCapil nik:" + dukcapilResponse.getNik());
              NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), "dukCapil tgl lhr:" + dukcapilResponse.getTanggalLahir());
              
              ifr.setValue("result_channel_id", dukcapilResponse.getChannelId());
        	  ifr.setValue("result_no_kk", dukcapilResponse.getNoKK());
        	  ifr.setValue("result_nik", dukcapilResponse.getNik());
        	  ifr.setValue("result_nama_lengkap", dukcapilResponse.getNamaLengkap());
        	  ifr.setValue("result_jenis_kelamin", dukcapilResponse.getJenisKelamin());
        	  ifr.setValue("result_tempat_lahir", dukcapilResponse.getTempatLahir());
        	  ifr.setValue("result_tanggal_lahir", dukcapilResponse.getTanggalLahir());
        	  ifr.setValue("result_status_kawin", dukcapilResponse.getStatusKawin());
        	  ifr.setValue("result_jenis_pekerjaan", dukcapilResponse.getJenisPekerjaan());
        	  ifr.setValue("result_nama_ibu", dukcapilResponse.getNamaIbu());
        	  ifr.setValue("result_alamat", dukcapilResponse.getAlamat());
        	  ifr.setValue("result_no_provinsi", dukcapilResponse.getNoProvinsi());
        	  ifr.setValue("result_no_kabupaten", dukcapilResponse.getNoKabupaten());
        	  ifr.setValue("result_no_kecamatan", dukcapilResponse.getNoKecamatan());
        	  ifr.setValue("result_no_kelurahan", dukcapilResponse.getNoKelurahan());
        	  ifr.setValue("result_nama_provinsi", dukcapilResponse.getNamaProvinsi());
        	  ifr.setValue("result_nama_kabupaten", dukcapilResponse.getNamaKabupaten());
        	  ifr.setValue("result_nama_kelurahan", dukcapilResponse.getNamaKelurahan());
        	  ifr.setValue("result_rw", dukcapilResponse.getRw());
        	  ifr.setValue("result_rt", dukcapilResponse.getRt());
        	  ifr.setValue("result_threshold", dukcapilResponse.getThreshold());
        	  

			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_channel_id "+ dukcapilResponse.getChannelId());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_no_kk "+ dukcapilResponse.getNoKK());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_nik "+ dukcapilResponse.getNik());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_nama_lengkap "+ dukcapilResponse.getNamaLengkap());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_jenis_kelamin "+ dukcapilResponse.getJenisKelamin());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_tempat_lahir "+ dukcapilResponse.getTempatLahir());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_tanggal_lahir "+ dukcapilResponse.getTanggalLahir());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_status_kawin "+ dukcapilResponse.getStatusKawin());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_jenis_pekerjaan "+ dukcapilResponse.getJenisPekerjaan());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_nama_ibu "+ dukcapilResponse.getNamaIbu());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_alamat "+ dukcapilResponse.getAlamat());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_no_provinsi "+ dukcapilResponse.getNoProvinsi());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_no_kabupaten "+ dukcapilResponse.getNoKabupaten());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_no_kecamatan "+ dukcapilResponse.getNoKecamatan());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_no_kelurahan "+ dukcapilResponse.getNoKelurahan());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_nama_provinsi "+ dukcapilResponse.getNamaProvinsi());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_nama_kabupaten "+ dukcapilResponse.getNamaKabupaten());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_nama_kelurahan "+ dukcapilResponse.getNamaKelurahan());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_rw "+ dukcapilResponse.getRw());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_rt "+ dukcapilResponse.getRt());
			NGLogger.writeConsoleLog(ifr.getCabinetName() , ifr.getProcessName(),"result_threshold "+ dukcapilResponse.getThreshold());

        	  
          }
          
          NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), "hit API success!");
          
      } catch (Exception e) {
    	  StringWriter sw = new StringWriter();
    	    PrintWriter pw = new PrintWriter(sw);
    	    e.printStackTrace(pw);
    	    String stackTrace = sw.toString();
    	    
    	    hitStatus = "FAILED";
    	    errorMsg = e.getMessage();
    	    
    	  NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), "Exception: " + e.getMessage());
    	  NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), "Exception detail: " + e.getCause());
    	  NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), stackTrace);
          e.printStackTrace();
      }
	  
      LocalDateTime now = LocalDateTime.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
      String formattedTime = now.format(formatter);
      
	  String auditQuery = auditQueryTemplate
			  .replace("@CREATED_AT",formattedTime)
			  .replace("@CHANNEL_ID",dukRequest.getChannelId())
			  .replace("@NO_KK",dukRequest.getNoKK())
			  .replace("@NIK", dukRequest.getNik())
			  .replace("@NAMA_LENGKAP",dukRequest.getNamaLengkap())
			  .replace("@JENIS_KELAMIN",dukRequest.getJenisKelamin())
			  .replace("@TEMPAT_LAHIR",dukRequest.getTempatLahir())
			  .replace("@TANGGAL_LAHIR",dukRequest.getTanggalLahir())
			  .replace("@STATUS_KAWIN",dukRequest.getStatusKawin())
			  .replace("@JENIS_PEKERJAAN",dukRequest.getJenisPekerjaan())
			  .replace("@NAMA_IBU",dukRequest.getNamaIbu())
			  .replace("@ALAMAT",dukRequest.getAlamat())
			  .replace("@NO_PROVINSI",dukRequest.getNoProvinsi())
			  .replace("@NO_KABUPATEN",dukRequest.getNoKabupaten())
			  .replace("@NO_KECAMATAN",dukRequest.getNoKecamatan())
			  .replace("@NO_KELURAHAN",dukRequest.getNoKelurahan())
			  .replace("@NAMA_PROVINSI",dukRequest.getNamaProvinsi())
			  .replace("@NAMA_KABUPATEN",dukRequest.getNamaKabupaten())
			  .replace("@NAMA_KELURAHAN",dukRequest.getNamaKelurahan())
			  .replace("@RW",dukRequest.getRw())
			  .replace("@RT",dukRequest.getRt())
			  .replace("@THRESHOLD",dukRequest.getThreshold())
			  .replace("@DUKCAPIL_RESPONSE_JSON",dukcapilResponseJson)
			  .replace("@HIT_STATUS",hitStatus)
			  .replace("@HIT_ERROR_MSG",errorMsg);
	  
	  
	  
	  NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), "Query: " + auditQuery);
	  int insertStatus = ifr.saveDataInDB(auditQuery);
	  
	  NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), "minerale call api finished, insert status: " + insertStatus);
	  
	  // RULE FLEXI KTP API CALL
	  
	  
	  try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
          HttpPost rulePostRequest = new HttpPost("http://192.168.139.163:7001/brmsrest/rest/exec?versionNo=8.0&rulesetName=ktp_flexi&cabinetName=lmsretail4&isRuleFlow=N&encrypted=N&rulePackageID=73&isProtected=N");
          rulePostRequest.setHeader("Content-Type", "application/json");
          
          FlexiRequestMember flexiOutputMember = new FlexiRequestMember();
          flexiOutputMember.setName("decision");
          flexiOutputMember.setType(10);
          flexiOutputMember.setValue("1");
          
          FlexiRequestOutput flexiOutput = new FlexiRequestOutput();
          flexiOutput.setClassIsArray("N");
          flexiOutput.setMember(flexiOutputMember);
          flexiOutput.setClassName("ktp_output");
          
          FlexiRequestMember flexiInputMember1 = new FlexiRequestMember();
          flexiInputMember1.setName("dob");
          flexiInputMember1.setType(10);
          flexiInputMember1.setValue(dukcapilResponse.getTanggalLahir());
          
          FlexiRequestMember flexiInputMember2 = new FlexiRequestMember();
          flexiInputMember2.setName("jenis_kelamin");
          flexiInputMember2.setType(10);
          flexiInputMember2.setValue(dukcapilResponse.getJenisKelamin());
          
          FlexiRequestMember flexiInputMember3 = new FlexiRequestMember();
          flexiInputMember3.setName("nama_ibu");
          flexiInputMember3.setType(10);
          flexiInputMember3.setValue(dukcapilResponse.getNamaIbu());
          
          FlexiRequestMember flexiInputMember4 = new FlexiRequestMember();
          flexiInputMember4.setName("nama_ktp");
          flexiInputMember4.setType(10);
          flexiInputMember4.setValue(dukcapilResponse.getNamaLengkap());
          
          FlexiRequestMember flexiInputMember5 = new FlexiRequestMember();
          flexiInputMember5.setName("pob");
          flexiInputMember5.setType(10);
          flexiInputMember5.setValue(dukcapilResponse.getTempatLahir());
          
          List<FlexiRequestMember> memberList = new ArrayList<>();
          memberList.add(flexiInputMember1);
          memberList.add(flexiInputMember2);
          memberList.add(flexiInputMember3);
          memberList.add(flexiInputMember4);
          memberList.add(flexiInputMember5);
          
          FlexiRequestInput flexiInput = new FlexiRequestInput();
          flexiInput.setClassIsArray("N");
          flexiInput.setClassName("ktp_input");
          flexiInput.setMember(memberList);
          
          FlexiRequest flexiRequest = new FlexiRequest();
          flexiRequest.setInput(flexiInput);
          flexiRequest.setOutput(flexiOutput);
          
          ObjectMapper mapper = new ObjectMapper();
          String jsonInputString = mapper.writeValueAsString(flexiRequest);
          
          NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), "\nFlexi Request: " + jsonInputString);
          
          StringEntity entity = new StringEntity(jsonInputString);
          rulePostRequest.setEntity(entity);
          
          NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), "proceed to hit Rule ");
          
          try (CloseableHttpResponse response = httpClient.execute(rulePostRequest)) {
        	  int statusCode = response.getStatusLine().getStatusCode();
              NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), "Response Code: " + statusCode);
              
              String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
              
              String flexiResponseJsonString = responseString;
              
              NGLogger.writeConsoleLog(ifr.getCabinetName(), ifr.getProcessName(), "Flexi Response: " + flexiResponseJsonString);
              ObjectMapper objectMapper = new ObjectMapper();
              FlexiResponse flexiResponse = objectMapper.readValue(responseString, FlexiResponse.class);
              ifr.setValue("hit_status", flexiResponse.getOutput().getKtpOutput().getDecision());
          }
          
	  }catch (Exception e) {
		  
	  }
	  return "";
	  
  }
  
  public void postHookOnDocumentOperations(IFormReference objReference, String controlId, String docType, int docImageIndex, String operationType) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
