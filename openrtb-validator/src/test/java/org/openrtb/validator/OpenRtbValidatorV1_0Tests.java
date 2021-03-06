/*
 * ============================================================================
 * Copyright (c) 2013, Nexage, Inc.
 * All rights reserved.
 * Provided under BSD License as follows:
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1.  Redistributions of source code must retain the above copyright notice, 
 *     this list of conditions and the following disclaimer.
 * 2.  Redistributions in binary form must reproduce the above copyright 
 *     notice, this list of conditions and the following disclaimer in the 
 *     documentation and/or other materials provided with the distribution.
 * 3.  Neither the name of Nexage, Inc. nor the names of its contributors may 
 *     be used to endorse or promote products derived from this software 
 *     without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * ============================================================================
 */

package org.openrtb.validator;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.exceptions.ProcessingException;
import com.github.fge.jsonschema.report.ProcessingReport;

/**
 * Test examples taken from OpenRTB v1.0 specification document. 
 */
public class OpenRtbValidatorV1_0Tests {

	private static final Logger logger = LoggerFactory.getLogger(OpenRtbValidatorV1_0Tests.class);
	
    @Test
    public void testBidRequestSite() throws IOException, ProcessingException {
		OpenRtbValidator validator = OpenRtbValidatorFactory.getValidator(OpenRtbInputType.BID_REQUEST, OpenRtbVersion.V1_0);

		String resource = "/v1_0/bid_requests/full_bid_request_site.json";
		ProcessingReport report = validator.validate(JsonLoader.fromResource(resource));

		logger.info("validation report: " + report);
		assertTrue(resource + " is not valid", report.isSuccess());
    }
    
    @Test
    public void testBidRequestApp() throws IOException, ProcessingException {
    	OpenRtbValidator validator = OpenRtbValidatorFactory.getValidator(OpenRtbInputType.BID_REQUEST, OpenRtbVersion.V1_0);

		String resource = "/v1_0/bid_requests/full_bid_request_app.json";
		ProcessingReport report = validator.validate(JsonLoader.fromResource(resource));

		logger.info("validation report: " + report);
		assertTrue(resource + " is not valid", report.isSuccess());
    }
    
    @Test
    public void testBidResponse() throws IOException, ProcessingException {
    	OpenRtbValidator validator = OpenRtbValidatorFactory.getValidator(OpenRtbInputType.BID_RESPONSE, OpenRtbVersion.V1_0);

		String resource = "/v1_0/bid_responses/full_bid_response.json";
		ProcessingReport report = validator.validate(JsonLoader.fromResource(resource));

		logger.info("validation report: " + report);
		assertTrue(resource + " is not valid", report.isSuccess());
    }

}
