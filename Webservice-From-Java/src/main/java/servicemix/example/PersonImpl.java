package servicemix.example;

import javax.jws.WebService;
import javax.xml.ws.Holder;

import servicemix.example.types.GetPerson;
import servicemix.example.types.GetPersonResponse;

@WebService(serviceName = "PersonService", endpointInterface = "servicemix.example.Person")
public class PersonImpl implements Person {

    public void getPerson(Holder<String> personId, Holder<String> ssn, Holder<String> name)
        throws UnknownPersonFault
    {
        if (personId.value == null || personId.value.length() == 0) {
            servicemix.example.types.UnknownPersonFault fault = new servicemix.example.types.UnknownPersonFault();
            fault.setPersonId(personId.value);
            throw new UnknownPersonFault(null,fault);
        }
        name.value = "Guillaume";
        ssn.value = "000-000-0000";
    }

}
