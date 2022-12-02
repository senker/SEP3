/*
package via.sep3.persistencetier;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import via.sep3.persistencetier.protobuf.*;
import via.sep3.persistencetier.service.SellerService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
@ExtendWith(SpringExtension.class)
@RunWith(JUnit4.class)
@WebMvcTest
class SellerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SellerService sellerService;

	@Autowired
	private ObjectMapper objectMapper;


	ManagedChannel managedChannel = ManagedChannelBuilder
			.forAddress("localhost", 6565)
			.usePlaintext()
			.build();

	SellerServiceGrpc.SellerServiceBlockingStub synchronousStub;

	SellerServiceGrpc.SellerServiceStub asynchronousStub;

	@BeforeEach
	public void setup()
	{
		synchronousStub = SellerServiceGrpc.newBlockingStub(managedChannel);
		asynchronousStub = SellerServiceGrpc.newStub(managedChannel);
		sellerService = new SellerService();
	}

	@Test
	public void grpcCreateSeller() throws Exception{
		CreateSellerRequest request = setRandomSellerRequest();

		SellerResponse response = synchronousStub.createSeller(request);

		CreateSellerRequest responseToCreateSellerRequest = convertToCreateSellerRequest(response);

		assertEquals(request, responseToCreateSellerRequest);
	}

	@Test
	public void grpcGetAllSellers() throws Exception{
		List<SellerResponse> sellerResponseList = new ArrayList<>();
			asynchronousStub.getAllSellers(Empty.newBuilder().build(), new StreamObserver<SellerResponse>() {
			@Override
			public void onNext(SellerResponse sellerResponse) {
				sellerResponseList.add(sellerResponse);
			}

			@Override
			public void onError(Throwable throwable) {

			}

			@Override
			public void onCompleted() {

			}
		});
			Thread.sleep(5000);

		assertEquals(sellerResponseList.get(0).getCvr(), 0);
	}


	@Test
	public void CreateSellerRest() throws Exception{
		//HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/vogella")).build();

		String exampleSeller="{\"user\":{\"firstName\":\"SellerFirstName\"," +
					"\"lastName\":\"SellerLastName\"," +
					"\"address\":{" +
						"\"city\":\"city\"," +
						"\"streetname\":\"StreetName\"," +
						"\"postcode\":\"9000\"}," +
					"\"phoneNumber\":\"987987987\"," +
					"\"email\":\"seller@gmail.com\"}," +
				"\"cvr\":5," +
				"\"companyName\":\"CompanyName\"," +
				"\"description\":\"Description\"," +
				"\"type\"                   }";


		String exampleSeller2 = "{\"firstName\":\"SellerFirstName\"," +
				"\"lastName\":\"SellerLastName\"," +
				"\"address\":{\"city\":\"City\"," +
				"\"First Example\",\"Second Example\"]}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/seller"
		).accept(MediaType.APPLICATION_JSON).content(exampleSeller).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertEquals("http://localhost/seller/1",
				response.getHeader(HttpHeaders.LOCATION));

	}





	private static CreateSellerRequest setRandomSellerRequest()
	{
		int randomValue = (int) Math.floor(Math.random()*10+111111111);
		CreateSellerRequest request = CreateSellerRequest.newBuilder()
				.setUser(CreateUserModelRequestSeller.newBuilder()
						.setFirstName("Seller1")
						.setLastName("Seller1")
						.setAddress(AddressModelSeller.newBuilder().setCity("City").setStreetName("StreetName").setPostCode(1234))
						.setPhoneNumber(123456789)
						.setEmail("seller@gmail.com")
				)
				.setCvr(randomValue)
				.setCompanyName("CompanyName")
				.setDescription("Description")
				.setType("type")
				.setWebsite("seller.com")
				.setRating(5).build();
		return request;
	}

	private static CreateSellerRequest convertToCreateSellerRequest(SellerResponse response)
	{
		CreateSellerRequest responseObject = CreateSellerRequest.newBuilder().
				setUser(CreateUserModelRequestSeller.newBuilder()
						.setFirstName(response.getUser().getFirstName())
						.setLastName(response.getUser().getLastName())
						.setAddress(response.getUser().getAddress())
						.setPhoneNumber(response.getUser().getPhoneNumber())
						.setEmail(response.getUser().getEmail()))
				.setCvr(response.getCvr())
				.setCompanyName(response.getCompanyName())
				.setDescription(response.getDescription())
				.setType(response.getType())
				.setWebsite(response.getWebsite())
				.setRating(response.getRating()).build();

		return responseObject;
	}
}

*/
