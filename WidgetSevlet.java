package com.thirdparty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * <code>WidgetSevlet</code> is a sample servlet which contains methods to use
 * the contact data posted by Agile CRM based on the servlet path. This servlet
 * returns HTML code to be shown in the custom widget.
 * 
 */
@SuppressWarnings("serial")
public class WidgetSevlet extends HttpServlet
{
	/**
	 * Process POST request
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		doGet(req, res);
	}

	/**
	 * Process GET request
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		String output = "";

		try
		{
			// Get reader to to read the posted data from request
			BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));

			String inputLine;

			// Iterate and read the data line by line
			while ((inputLine = reader.readLine()) != null)
			{
				output += inputLine;
			}

			reader.close();

			System.out.println("Contact data posted to widget servlet ");
			System.out.println(output);

			// Get writer to return HTML
			PrintWriter out = res.getWriter();

			// Retrieves properties of contact
			JSONArray properties = new JSONObject(output).getJSONArray("properties");

			// Build HTML using contact details
			String html = "<html><div style='padding:10px;margin:0px;word-wrap:break-word;'>";

			html += "<ul style='margin:0px;padding:10px;'>";

			html += "<li class='row-fluid'>";
			html += "<div class='span5'><b>First Name</b><div class='pull-right'>:</div></div>";
			html += "<div class='span6' style='margin-left: 10px;'>" + getValueForKey(properties, "first_name")
					+ "</div>";
			html += "</li>";

			html += "<li class='row-fluid'>";
			html += "<div class='span5'><b>Last Name</b><div class='pull-right'>:</div></div>";
			html += "<div class='span6' style='margin-left: 10px;'>" + getValueForKey(properties, "last_name")
					+ "</div>";
			html += "</li>";

			html += "<li class='row-fluid'>";
			html += "<div class='span5'><b>Title</b><div class='pull-right'>:</div></div>";
			html += "<div class='span6' style='margin-left: 10px;'>" + getValueForKey(properties, "title") + "</div>";
			html += "</li>";

			html += "<li class='row-fluid'>";
			html += "<div class='span5'><b>Email</b><div class='pull-right'>:</div></div>";
			html += "<div class='span6' style='margin-left: 10px;'>" + getValueForKey(properties, "email") + "</div>";
			html += "</li>";

			html += "<li class='row-fluid'>";
			html += "<div class='span5'><b>Image URL</b><div class='pull-right'>:</div></div>";
			html += "<div class='span6' style='margin-left: 10px;'>" + getValueForKey(properties, "image") + "</div>";
			html += "</li>";
			html += "</ul></div></html>";

			out.println(html);

		}
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method retrieves value of contact property for the given key
	 * 
	 * @param array
	 *            {@link JSONArray} of contact properties
	 * @param key
	 *            {@link String} name of contact property
	 * @return {@link String} value of the contact property related to the gievn
	 *         key
	 */
	public String getValueForKey(JSONArray array, String key)
	{
		for (int i = 0; i < array.length(); i++)
		{
			try
			{
				if (array.getJSONObject(i).getString("name").equalsIgnoreCase(key))
					return array.getJSONObject(i).getString("value");
			}
			catch (JSONException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}