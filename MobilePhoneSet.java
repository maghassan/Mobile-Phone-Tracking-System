public class MobilePhoneSet extends Myset{
	public MobilePhoneSet(){
		super();
    }
     public MobilePhone searchPhone(int id) throws MobilePhoneNotFoundException{
        //System.out.println("Inside searchPhone() " + id);
        MyLinkedList.Node itr = myset.head;
        MobilePhone mobile = null;
        if(itr!=null){
        	mobile = (MobilePhone) itr.data;
        }	
        while(itr!=null && (mobile.number() != id)){
            itr = itr.next;
            if(itr!=null){
        		mobile = (MobilePhone)itr.data;
        	}
        }
        if(mobile == null){
            throw new MobilePhoneNotFoundException("Error- No mobile phone with identifer "+id);
        }
        if(mobile.number() != id){
            throw new MobilePhoneNotFoundException("Error- No mobile phone with identifer "+id);
        }
        return mobile;
    }    
}