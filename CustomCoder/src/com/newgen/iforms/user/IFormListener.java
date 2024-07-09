package com.newgen.iforms.user;

import com.newgen.iforms.custom.IFormListenerFactory;
import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.custom.IFormServerEventHandler;

public class IFormListener implements IFormListenerFactory {
    
  public IFormServerEventHandler getClassInstance(IFormReference ifr) {
      try{
    return new CustomCodeHandler();
      }
      catch(Exception | Error ex){
          ex.printStackTrace();
      }
      
      return null;
  }
  
}
