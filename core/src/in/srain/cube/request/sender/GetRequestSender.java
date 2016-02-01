package in.srain.cube.request.sender;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

import in.srain.cube.request.IRequest;

public class GetRequestSender extends BaseRequestSender {

	public GetRequestSender(IRequest<?> request, HttpURLConnection httpURLConnection) {
		super(request, httpURLConnection);
	}

	@Override
	public void setup() throws IOException {
		mHttpURLConnection.setRequestMethod("GET");
		mHttpURLConnection.setReadTimeout(10000 /* milliseconds */);
		mHttpURLConnection.setConnectTimeout(15000 /* milliseconds */);
		mHttpURLConnection.setDoOutput(true);
		mHttpURLConnection.setDoInput(true);
		super.setup();
	}

	@Override
	public void send() throws IOException {
		OutputStreamWriter writer = new OutputStreamWriter(mHttpURLConnection.getOutputStream());
		writer.write(mRequestData.getPostString());
		writer.flush();
	}
}
