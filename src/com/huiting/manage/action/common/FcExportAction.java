package com.huiting.manage.action.common;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.io.output.ByteArrayOutputStream;


public class FcExportAction extends BaseAction {
	private static final long serialVersionUID = -2931283276430865136L;

	private String meta_DOMId;
	private String htmlParam;
	private int meta_width = 0;
	private int meta_height = 0;
	// Default background color of the chart
	private String meta_bgColor = "";
	private String stream = "";
	private String parameters = "";
	private ByteArrayOutputStream bs ;

	public String export() {
//		String name = "";
		if (parameters != null && !"".equals(parameters)) {
			String[] names = parameters.split("\\|");
			for (String node : names) {
				if (node.contains("exportFileName")) {
//					name = node.split("=")[1];
				}
			}
		}
//		HttpServletRequest rqst = this.getRequest();
		String[] rows;
		Color bgColor;
		if (meta_bgColor == null || meta_bgColor == "" || meta_bgColor == null) {
			meta_bgColor = "FFFFFF";
		}
		// Convert background color to color object
		bgColor = new Color(Integer.parseInt(meta_bgColor, 16));
		if (stream != null) {
			try {
				// Parse data
				rows = new String[meta_height + 1];
				rows = stream.split(";");

				// Bitmap to store the chart.
				// Reference to graphics object - gr
				BufferedImage chart = new BufferedImage(meta_width,
						meta_height, BufferedImage.TYPE_3BYTE_BGR);
				Graphics gr = chart.createGraphics();
				gr.setColor(bgColor);
				gr.fillRect(0, 0, meta_width, meta_height);

				String c;
				int r;
				int ri = 0;
				for (int i = 0; i < rows.length; i++) {
					// Split individual pixels.
					String[] pixels = rows[i].split(",");
					// Set horizontal row index to 0
					ri = 0;
					for (int j = 0; j < pixels.length; j++) {
						// Now, if it's not empty, we process it
						// Split the color and repeat factor

						String[] clrs = pixels[j].split("_");
						// Reference to color
						c = clrs[0];
						r = Integer.parseInt(clrs[1]);

						// If color is not empty (i.e. not background pixel)
						if (c != null && c.length() > 0 && c != "") {
							if (c.length() < 6) {
								// If the hexadecimal code is less than 6
								// characters, pad with 0
								StringBuffer str = new StringBuffer(c);
//								int strLength = str.length();
								for (int p = c.length() + 1; p <= 6; p++) {
									str.insert(0, "0");
								}
								// Assing the new padded string
								c = str.toString();
							}
							for (int k = 1; k <= r; k++) {
								// Draw each pixel
								gr.setColor(new Color(Integer.parseInt(c, 16)));
								gr.fillRect(ri, i, 1, 1);
								// Increment horizontal row count
								ri++;
							}
						} else {
							// Just increment horizontal index
							ri = ri + r;
						}
					}
				}
				bs=new ByteArrayOutputStream();
				ImageOutputStream imOut =ImageIO.createImageOutputStream(bs);
				ImageIO.write(chart, "jpg", imOut);
				/*String absoultPath = PropertiesUtil.getVlue("flash.path");
				absoultPath = absoultPath.replaceAll("\\\\", "/");
				new File(absoultPath).mkdirs();
				// String filePathString
				// =Long.toString(DateTool.getNow().getTime());
				String fileName = absoultPath + "/" + name + ".jpg";
				ImageIO.write(chart, "jpg", new File(fileName));
				HttpServletResponse resp = this.getResponse();
				PrintWriter out = this.getResponse().getWriter();
				resp.setContentType("text/html");
				resp.addHeader("Content-Disposition", "inline; filename=\""
						+ fileName + "\"");
				out.print("&width=15&height=15&DOMId=" + this.meta_DOMId
						+ "&fileName=" + fileName
						+ "&notice=&statusCode=1&statusMessage=Success");*/
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// htmlParam = "{'picName':'test.jpg'}";

		// return Action.SUCCESS;
		return SUCCESS;

	}
	public InputStream getInputStream() throws IOException{
		return new ByteArrayInputStream(bs.toByteArray()); 
	}

	public int getMeta_width() {
		return meta_width;
	}

	public void setMeta_width(int meta_width) {
		this.meta_width = meta_width;
	}

	public int getMeta_height() {
		return meta_height;
	}

	public void setMeta_height(int meta_height) {
		this.meta_height = meta_height;
	}

	public String getMeta_bgColor() {
		return meta_bgColor;
	}

	public void setMeta_bgColor(String meta_bgColor) {
		this.meta_bgColor = meta_bgColor;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getHtmlParam() {
		return htmlParam;
	}

	public void setHtmlParam(String htmlParam) {
		this.htmlParam = htmlParam;
	}

	public String getMeta_DOMId() {
		return meta_DOMId;
	}

	public void setMeta_DOMId(String meta_DOMId) {
		this.meta_DOMId = meta_DOMId;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

}