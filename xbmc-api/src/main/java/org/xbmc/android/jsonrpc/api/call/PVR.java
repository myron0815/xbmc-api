/*
 *      Copyright (C) 2005-2013 Team XBMC
 *      http://xbmc.org
 *
 *  This Program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2, or (at your option)
 *  any later version.
 *
 *  This Program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with XBMC Remote; see the file license.  If not, write to
 *  the Free Software Foundation, 675 Mass Ave, Cambridge, MA 02139, USA.
 *  http://www.gnu.org/copyleft/gpl.html
 *
 */
package org.xbmc.android.jsonrpc.api.call;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.xbmc.android.jsonrpc.api.AbstractCall;
import org.xbmc.android.jsonrpc.api.AbstractModel;
import org.xbmc.android.jsonrpc.api.model.GlobalModel;
import org.xbmc.android.jsonrpc.api.model.ListModel;
import org.xbmc.android.jsonrpc.api.model.PVRModel;

public final class PVR {

	/**
	 * Retrieves the details of a specific channel.
	 * <p/>
	 * This class represents the API method <tt>PVR.GetChannelDetails</tt>
	 * <p/>
	 * <i>This class was generated automatically from XBMC's JSON-RPC introspect.</i>
	 */
	public static class GetChannelDetails extends AbstractCall<PVRModel.ChannelDetail> {
		public final static String API_TYPE = "PVR.GetChannelDetails";
		public final static String RESULT = "channeldetails";

		/**
		 * Retrieves the details of a specific channel.
		 * @param channelid 
		 * @param properties  One or more of: <tt>thumbnail</tt>, <tt>channeltype</tt>, <tt>hidden</tt>, <tt>locked</tt>, <tt>channel</tt>, <tt>lastplayed</tt>. See constants at {@link PVRModel.ChannelFields}.
		 */
		public GetChannelDetails(Integer channelid, String... properties) {
			super();
			addParameter("channelid", channelid);
			addParameter("properties", properties);
		}

		@Override
		protected PVRModel.ChannelDetail parseOne(JsonNode node) {
			return new PVRModel.ChannelDetail((ObjectNode)node.get(RESULT));
		}

		@Override
		public String getName() {
			return API_TYPE;
		}

		@Override
		protected boolean returnsList() {
			return false;
		}
	}

	/**
	 * Retrieves the details of a specific channel group.
	 * <p/>
	 * This class represents the API method <tt>PVR.GetChannelGroupDetails</tt>
	 * <p/>
	 * <i>This class was generated automatically from XBMC's JSON-RPC introspect.</i>
	 */
	public static class GetChannelGroupDetails extends AbstractCall<PVRModel.ChannelGroupExtendedDetail> {
		public final static String API_TYPE = "PVR.GetChannelGroupDetails";
		public final static String RESULT = "channelgroupdetails";

		/**
		 * Retrieves the details of a specific channel group.
		 * @param channelgroupid 
		 * @param channels 
		 */
		public GetChannelGroupDetails(PVRModel.ChannelGroupId channelgroupid, Channel channels) {
			super();
			addParameter("channelgroupid", channelgroupid);
			addParameter("channels", channels);
		}

		/**
		 * Retrieves the details of a specific channel group.
		 * @param channelgroupid 
		 */
		public GetChannelGroupDetails(PVRModel.ChannelGroupId channelgroupid) {
			super();
			addParameter("channelgroupid", channelgroupid);
		}

		@Override
		protected PVRModel.ChannelGroupExtendedDetail parseOne(JsonNode node) {
			return new PVRModel.ChannelGroupExtendedDetail((ObjectNode)node.get(RESULT));
		}

		@Override
		public String getName() {
			return API_TYPE;
		}

		@Override
		protected boolean returnsList() {
			return false;
		}

		/**
		 * Note: This class is used as parameter only.<br/>
		 * <i>This class was generated automatically from XBMC's JSON-RPC introspect.</i>
		 */
		public static class Channel extends AbstractModel {

			// field names
			public static final String LIMITS = "limits";
			public static final String PROPERTIES = "properties";

			// class members
			public final ListModel.Limits limits;
			public final String properties;

			/**
			 * @param limits
			 * @param properties One or more of: <tt>thumbnail</tt>, <tt>channeltype</tt>, <tt>hidden</tt>, <tt>locked</tt>, <tt>channel</tt>, <tt>lastplayed</tt>. See constants at {@link PVR.Channel.Property}.
			 */
			public Channel(ListModel.Limits limits, String properties) {
				this.limits = limits;
				this.properties = properties;
			}

			@Override
			public JsonNode toJsonNode() {
				final ObjectNode node = OM.createObjectNode();
				node.put(LIMITS, limits.toJsonNode());
				node.put(PROPERTIES, properties); // enum
				return node;
			}

			/**
			 * API Name: <tt>properties</tt>
			 */
			public interface Property {

				public final String THUMBNAIL = "thumbnail";
				public final String CHANNELTYPE = "channeltype";
				public final String HIDDEN = "hidden";
				public final String LOCKED = "locked";
				public final String CHANNEL = "channel";
				public final String LASTPLAYED = "lastplayed";

				public final static Set<String> values = new HashSet<String>(Arrays.asList(THUMBNAIL, CHANNELTYPE, HIDDEN, LOCKED, CHANNEL, LASTPLAYED));
			}
		}
	}

	/**
	 * Retrieves the channel groups for the specified type.
	 * <p/>
	 * This class represents the API method <tt>PVR.GetChannelGroups</tt>
	 * <p/>
	 * <i>This class was generated automatically from XBMC's JSON-RPC introspect.</i>
	 */
	public static class GetChannelGroups extends AbstractCall<PVRModel.ChannelGroupDetail> {
		public final static String API_TYPE = "PVR.GetChannelGroups";
		public final static String RESULT = "channelgroups";

		/**
		 * Retrieves the channel groups for the specified type.
		 * @param channeltype  One of: <tt>tv</tt>, <tt>radio</tt>. See constants at {@link PVRModel.ChannelType}.
		 * @param limits 
		 */
		public GetChannelGroups(String channeltype, ListModel.Limits limits) {
			super();
			addParameter("channeltype", channeltype);
			addParameter("limits", limits);
		}

		/**
		 * Retrieves the channel groups for the specified type.
		 * @param channeltype  One of: <tt>tv</tt>, <tt>radio</tt>. See constants at {@link PVRModel.ChannelType}.
		 */
		public GetChannelGroups(String channeltype) {
			super();
			addParameter("channeltype", channeltype);
		}

		@Override
		protected ArrayList<PVRModel.ChannelGroupDetail> parseMany(JsonNode node) {
			final ArrayNode channelgroups = parseResults(node, RESULT);
			if (channelgroups != null) {
				final ArrayList<PVRModel.ChannelGroupDetail> ret = new ArrayList<PVRModel.ChannelGroupDetail>(channelgroups.size());
				for (int i = 0; i < channelgroups.size(); i++) {
					final ObjectNode item = (ObjectNode)channelgroups.get(i);
					ret.add(new PVRModel.ChannelGroupDetail(item));
				}
				return ret;
			} else {
				return new ArrayList<PVRModel.ChannelGroupDetail>(0);
			}
		}

		@Override
		public String getName() {
			return API_TYPE;
		}

		@Override
		protected boolean returnsList() {
			return true;
		}
	}

	/**
	 * Retrieves the channel list.
	 * <p/>
	 * This class represents the API method <tt>PVR.GetChannels</tt>
	 * <p/>
	 * <i>This class was generated automatically from XBMC's JSON-RPC introspect.</i>
	 */
	public static class GetChannels extends AbstractCall<PVRModel.ChannelDetail> {
		public final static String API_TYPE = "PVR.GetChannels";
		public final static String RESULT = "channels";

		/**
		 * Retrieves the channel list.
		 * @param channelgroupid 
		 * @param limits 
		 * @param properties  One or more of: <tt>thumbnail</tt>, <tt>channeltype</tt>, <tt>hidden</tt>, <tt>locked</tt>, <tt>channel</tt>, <tt>lastplayed</tt>. See constants at {@link PVRModel.ChannelFields}.
		 */
		public GetChannels(PVRModel.ChannelGroupId channelgroupid, ListModel.Limits limits, String... properties) {
			super();
			addParameter("channelgroupid", channelgroupid);
			addParameter("limits", limits);
			addParameter("properties", properties);
		}

		/**
		 * Retrieves the channel list.
		 * @param channelgroupid 
		 * @param properties  One or more of: <tt>thumbnail</tt>, <tt>channeltype</tt>, <tt>hidden</tt>, <tt>locked</tt>, <tt>channel</tt>, <tt>lastplayed</tt>. See constants at {@link PVRModel.ChannelFields}.
		 */
		public GetChannels(PVRModel.ChannelGroupId channelgroupid, String... properties) {
			super();
			addParameter("channelgroupid", channelgroupid);
			addParameter("properties", properties);
		}

		@Override
		protected ArrayList<PVRModel.ChannelDetail> parseMany(JsonNode node) {
			final ArrayNode channels = parseResults(node, RESULT);
			if (channels != null) {
				final ArrayList<PVRModel.ChannelDetail> ret = new ArrayList<PVRModel.ChannelDetail>(channels.size());
				for (int i = 0; i < channels.size(); i++) {
					final ObjectNode item = (ObjectNode)channels.get(i);
					ret.add(new PVRModel.ChannelDetail(item));
				}
				return ret;
			} else {
				return new ArrayList<PVRModel.ChannelDetail>(0);
			}
		}

		@Override
		public String getName() {
			return API_TYPE;
		}

		@Override
		protected boolean returnsList() {
			return true;
		}
	}

	/**
	 * Retrieves the values of the given properties.
	 * <p/>
	 * This class represents the API method <tt>PVR.GetProperties</tt>
	 * <p/>
	 * <i>This class was generated automatically from XBMC's JSON-RPC introspect.</i>
	 */
	public static class GetProperties extends AbstractCall<PVRModel.PropertyValue> {
		public final static String API_TYPE = "PVR.GetProperties";

		/**
		 * Retrieves the values of the given properties.
		 * @param properties  One or more of: <tt>available</tt>, <tt>recording</tt>, <tt>scanning</tt>. See constants at {@link PVRModel.PropertyName}.
		 */
		public GetProperties(String... properties) {
			super();
			addParameter("properties", properties);
		}

		@Override
		protected PVRModel.PropertyValue parseOne(JsonNode node) {
			return new PVRModel.PropertyValue(node);
		}

		@Override
		public String getName() {
			return API_TYPE;
		}

		@Override
		protected boolean returnsList() {
			return false;
		}
	}

	/**
	 * Toggle recording of a channel.
	 * <p/>
	 * This class represents the API method <tt>PVR.Record</tt>
	 * <p/>
	 * <i>This class was generated automatically from XBMC's JSON-RPC introspect.</i>
	 */
	public static class Record extends AbstractCall<String> {
		public final static String API_TYPE = "PVR.Record";

		/**
		 * Toggle recording of a channel.
		 * @param record 
		 * @param channel  One of: <tt>current</tt>. See constants at {@link PVR.Record.Channel}.
		 */
		public Record(GlobalModel.Toggle record, String channel) {
			super();
			addParameter("record", record);
			addParameter("channel", channel);
		}

		/**
		 * Toggle recording of a channel.
		 * @param record 
		 * @param channel 
		 */
		public Record(GlobalModel.Toggle record, Integer channel) {
			super();
			addParameter("record", record);
			addParameter("channel", channel);
		}

		/**
		 * Toggle recording of a channel.
		 */
		public Record() {
			super();
		}

		/**
		 * Toggle recording of a channel.
		 * @param record 
		 */
		public Record(GlobalModel.Toggle record) {
			super();
			addParameter("record", record);
		}

		@Override
		protected String parseOne(JsonNode node) {
			return node.getTextValue();
		}

		@Override
		public String getName() {
			return API_TYPE;
		}

		@Override
		protected boolean returnsList() {
			return false;
		}

		/**
		 * API Name: <tt>channel</tt>
		 */
		public interface Channel {

			public final String CURRENT = "current";

			public final static Set<String> values = new HashSet<String>(Arrays.asList(CURRENT));
		}
	}

	/**
	 * Starts a channel scan.
	 * <p/>
	 * This class represents the API method <tt>PVR.Scan</tt>
	 * <p/>
	 * <i>This class was generated automatically from XBMC's JSON-RPC introspect.</i>
	 */
	public static class Scan extends AbstractCall<String> {
		public final static String API_TYPE = "PVR.Scan";

		/**
		 * Starts a channel scan.
		 */
		public Scan() {
			super();
		}

		@Override
		protected String parseOne(JsonNode node) {
			return node.getTextValue();
		}

		@Override
		public String getName() {
			return API_TYPE;
		}

		@Override
		protected boolean returnsList() {
			return false;
		}
	}
}
