 var    hkey_root,hkey_path,hkey_key   
        hkey_root="HKEY_CURRENT_USER"   
        hkey_path="\\Software\\Microsoft\\Internet   Explorer\\PageSetup\\"   
  function   pagesetup_null()   
  {   
      try{   
          var   RegWsh   =   new   ActiveXObject("WScript.Shell")   
          hkey_key="header"           
          RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"")   
          hkey_key="footer"   
          RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"")   
      }catch(e){}   
  }   

function printBase() {
factory.printing.header  = '';  
factory.printing.footer = '';   
factory.printing.portrait = true ;   
factory.printing.leftMargin   =   0.5  ;
factory.printing.topMargin   =   1.5   ;
factory.printing.rightMargin   =   0.5  ;
factory.printing.bottomMargin   =   1.5   ;
}

function printReport(){
        printBase();
        pagesetup_null();
        document.all("button").style.display = "none"; 
        factory.printing.Preview();
}

maxWin();
function maxWin()
{
      var aw = screen.availWidth;
      var ah = screen.availHeight;
      window.moveTo(0, 0);
      window.resizeTo(aw, ah);
}

function printTure()
{
     printBase();
     document.all("button").style.display = "none"; 
     factory.printing.Print(true);
     document.all("button").style.display = "block"; 
}
