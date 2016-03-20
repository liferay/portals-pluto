/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.portals.samples;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Scott Nicklous
 * 
 */
public class PathDisplay {

   private String async_request_uri;
   private String async_context_path;
   private String async_servlet_path;
   private String async_path_info;
   private String async_query_string;

   private String forward_request_uri;
   private String forward_context_path;
   private String forward_servlet_path;
   private String forward_path_info;
   private String forward_query_string;

   private String include_request_uri;
   private String include_context_path;
   private String include_servlet_path;
   private String include_path_info;
   private String include_query_string;

   private String method_request_uri;
   private String method_context_path;
   private String method_servlet_path;
   private String method_path_info;
   private String method_query_string;
   
   private String type;
   private String caller;
   private boolean isAsyncSupported = false;

   public PathDisplay(HttpServletRequest req, String caller) {
      this.caller = caller;
      
      async_request_uri = (String) req.getAttribute("javax.servlet.async.request_uri");
      async_context_path = (String) req.getAttribute("javax.servlet.async.context_path");
      async_servlet_path = (String) req.getAttribute("javax.servlet.async.servlet_path");
      async_path_info = (String) req.getAttribute("javax.servlet.async.path_info");
      async_query_string = (String) req.getAttribute("javax.servlet.async.query_string");

      forward_request_uri = (String) req.getAttribute("javax.servlet.forward.request_uri");
      forward_context_path = (String) req.getAttribute("javax.servlet.forward.context_path");
      forward_servlet_path = (String) req.getAttribute("javax.servlet.forward.servlet_path");
      forward_path_info = (String) req.getAttribute("javax.servlet.forward.path_info");
      forward_query_string = (String) req.getAttribute("javax.servlet.forward.query_string");

      include_request_uri = (String) req.getAttribute("javax.servlet.include.request_uri");
      include_context_path = (String) req.getAttribute("javax.servlet.include.context_path");
      include_servlet_path = (String) req.getAttribute("javax.servlet.include.servlet_path");
      include_path_info = (String) req.getAttribute("javax.servlet.include.path_info");
      include_query_string = (String) req.getAttribute("javax.servlet.include.query_string");

      method_request_uri = req.getRequestURI();
      method_context_path = req.getContextPath();
      method_servlet_path = req.getServletPath();
      method_path_info = req.getPathInfo();
      method_query_string = req.getQueryString();
      
      type = req.getDispatcherType().name();
      isAsyncSupported = req.isAsyncSupported();
}

   public PathDisplay(PortletRequest req, String caller) {
      this.caller = caller;
      
      async_request_uri = (String) req.getAttribute("javax.servlet.async.request_uri");
      async_context_path = (String) req.getAttribute("javax.servlet.async.context_path");
      async_servlet_path = (String) req.getAttribute("javax.servlet.async.servlet_path");
      async_path_info = (String) req.getAttribute("javax.servlet.async.path_info");
      async_query_string = (String) req.getAttribute("javax.servlet.async.query_string");

      forward_request_uri = (String) req.getAttribute("javax.servlet.forward.request_uri");
      forward_context_path = (String) req.getAttribute("javax.servlet.forward.context_path");
      forward_servlet_path = (String) req.getAttribute("javax.servlet.forward.servlet_path");
      forward_path_info = (String) req.getAttribute("javax.servlet.forward.path_info");
      forward_query_string = (String) req.getAttribute("javax.servlet.forward.query_string");

      include_request_uri = (String) req.getAttribute("javax.servlet.include.request_uri");
      include_context_path = (String) req.getAttribute("javax.servlet.include.context_path");
      include_servlet_path = (String) req.getAttribute("javax.servlet.include.servlet_path");
      include_path_info = (String) req.getAttribute("javax.servlet.include.path_info");
      include_query_string = (String) req.getAttribute("javax.servlet.include.query_string");

      method_request_uri = "undefined";
      method_context_path = req.getContextPath();
      method_servlet_path = "undefined";
      method_path_info = "undefined";
      method_query_string = "undefined";
      
      type = "undefined";
}

   public String toMarkup() {
      StringBuilder txt = new StringBuilder(128);
      txt.append("<hr>");
      txt.append("<h5>").append(caller).append(" Path Info:</h5>");
      txt.append("<table border='0' cellpadding='0'><tr>");

      txt.append("<td>Dispatch type:</td><td>").append(type).append("</td>\n");
      txt.append("</tr><tr><td style='padding-top:8px;'/></tr><tr>");

      if ((async_request_uri == null) && (async_context_path == null) && (async_servlet_path == null)
            && (async_path_info == null) && (async_query_string == null)) {
         txt.append("<td>Async values:</td><td>null.</td>\n");
      } else {
         txt.append("<td>async_request_uri:</td><td>").append(async_request_uri).append("</td>\n");
         txt.append("</tr><tr>");
         txt.append("<td>async_context_path:</td><td>").append(async_context_path).append("</td>\n");
         txt.append("</tr><tr>");
         txt.append("<td>async_servlet_path:</td><td>").append(async_servlet_path).append("</td>\n");
         txt.append("</tr><tr>");
         txt.append("<td>async_path_info:</td><td>").append(async_path_info).append("</td>\n");
         txt.append("</tr><tr>");
         txt.append("<td>async_query_string:</td><td>").append(async_query_string).append("</td>\n");
      }
      txt.append("</tr><tr>");
      txt.append("<td>isAsyncSupported:</td><td>").append(isAsyncSupported).append("</td>\n");

      txt.append("</tr><tr><td style='padding-top:8px;'/></tr><tr>");

      if ((forward_request_uri == null) && (forward_context_path == null) && (forward_servlet_path == null)
            && (forward_path_info == null) && (forward_query_string == null)) {
         txt.append("<td>Forward values:</td><td>null.</td>\n");
      } else {
         txt.append("<td>forward_request_uri:</td><td>").append(forward_request_uri).append("</td>\n");
         txt.append("</tr><tr>");
         txt.append("<td>forward_context_path:</td><td>").append(forward_context_path).append("</td>\n");
         txt.append("</tr><tr>");
         txt.append("<td>forward_servlet_path:</td><td>").append(forward_servlet_path).append("</td>\n");
         txt.append("</tr><tr>");
         txt.append("<td>forward_path_info:</td><td>").append(forward_path_info).append("</td>\n");
         txt.append("</tr><tr>");
         txt.append("<td>forward_query_string:</td><td>").append(forward_query_string).append("</td>\n");
      }
      txt.append("</tr><tr><td style='padding-top:8px;'/></tr><tr>");

      if ((include_request_uri == null) && (include_context_path == null) && (include_servlet_path == null)
            && (include_path_info == null) && (include_query_string == null)) {
         txt.append("<td>Include values:</td><td>null.</td>\n");
      } else {
         txt.append("<td>include_request_uri:</td><td>").append(include_request_uri).append("</td>\n");
         txt.append("</tr><tr>");
         txt.append("<td>include_context_path:</td><td>").append(include_context_path).append("</td>\n");
         txt.append("</tr><tr>");
         txt.append("<td>include_servlet_path:</td><td>").append(include_servlet_path).append("</td>\n");
         txt.append("</tr><tr>");
         txt.append("<td>include_path_info:</td><td>").append(include_path_info).append("</td>\n");
         txt.append("</tr><tr>");
         txt.append("<td>include_query_string:</td><td>").append(include_query_string).append("</td>\n");
      }
      txt.append("</tr><tr><td style='padding-top:8px;'/></tr><tr>");

      txt.append("<td>method_request_uri:</td><td>").append(method_request_uri).append("</td>\n");
      txt.append("</tr><tr>");
      txt.append("<td>method_context_path:</td><td>").append(method_context_path).append("</td>\n");
      txt.append("</tr><tr>");
      txt.append("<td>method_servlet_path:</td><td>").append(method_servlet_path).append("</td>\n");
      txt.append("</tr><tr>");
      txt.append("<td>method_path_info:</td><td>").append(method_path_info).append("</td>\n");
      txt.append("</tr><tr>");
      txt.append("<td>method_query_string:</td><td>").append(method_query_string).append("</td>\n");

      txt.append("</tr></table>");
      return txt.toString();
   }

}
