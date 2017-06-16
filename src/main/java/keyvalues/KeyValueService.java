package keyvalues;

import java.util.*;
import javax.servlet.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestController
public class KeyValueService {
	private HashMap<String, List> inMemoryStore = new HashMap<String, List>();

	public KeyValueService() {
		super();

		List<KeyValuePair> typesList = new ArrayList<KeyValuePair>();
		typesList.add(new KeyValuePair("MR", "Mr."));
		typesList.add(new KeyValuePair("MRS", "Mrs."));
		typesList.add(new KeyValuePair("MS", "Ms."));
		typesList.add(new KeyValuePair("SIR", "Sir"));
		typesList.add(new KeyValuePair("DR", "Dr"));

		inMemoryStore.put("SALUTATION", typesList);
	}

	@RequestMapping(value = "/keyvalues/{type}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<KeyValuePair> getKeyValues(
			@PathVariable(value = "type") String t,
			@RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
			@RequestParam(value = "recordCount", defaultValue = "10") int recordCount) {
		_log("Fetching key values for: " + t + ", page/record = " + pageNumber
				+ "/" + recordCount);
		List<KeyValuePair> list = inMemoryStore.get(t);
		if (list == null)
			throw new ServiceException(404,
					"Error: unknown type value specified: " + t, null);

		return list;
	}

	@RequestMapping(value = "/keyvalues/{type}", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<KeyValuePair> addEntry(@PathVariable(value = "type") String t,
			@RequestBody KeyValuePair v) {
		_log("Adding values for type: " + t);
		List<KeyValuePair> list = inMemoryStore.get(t);
		if (list == null)
			throw new ServiceException(404,
					"Error: unknown type value specified: " + t, null);

		if (v == null)
			throw new ServiceException(406,
					"Error: need an key value pair to add!", null);

		list.add(v);
		return list;
	}

	protected void _log(String s) {
		System.out.println(s);
	}
}