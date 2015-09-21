/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.finance.rate.future;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableDefaults;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.collect.id.LinkResolver;
import com.opengamma.strata.collect.id.StandardId;
import com.opengamma.strata.finance.SecurityLink;
import com.opengamma.strata.finance.SecurityTrade;
import com.opengamma.strata.finance.TradeInfo;

/**
 * A trade representing a futures contract based on an interest rate swap.
 * <p>
 * A trade in an underlying {@link DeliverableSwapFuture}.
 */
@BeanDefinition
public final class DeliverableSwapFutureTrade
    implements SecurityTrade<DeliverableSwapFuture>, ImmutableBean, Serializable {

  /**
   * The additional trade information, defaulted to an empty instance.
   * <p>
   * This allows additional information to be attached to the trade.
   */
  @PropertyDefinition(overrideGet = true)
  private final TradeInfo tradeInfo;
  /**
   * The link to the future that was traded.
   * <p>
   * This property returns a link to the security via a {@link StandardId}.
   * See {@link #getSecurity()} and {@link SecurityLink} for more details.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final SecurityLink<DeliverableSwapFuture> securityLink;
  /**
   * The quantity, indicating the number of future contracts in the trade.
   * <p>
   * This will be positive if buying and negative if selling.
   */
  @PropertyDefinition
  private final long quantity;
  /**
   * The trade price of the future.
   * <p>
   * This is the transaction price expressed in the convention of the futures.
   */
  @PropertyDefinition
  private final double tradePrice;

  //-------------------------------------------------------------------------
  @SuppressWarnings({"rawtypes", "unchecked" })
  @ImmutableDefaults
  private static void applyDefaults(Builder builder) {
    builder.tradeInfo = TradeInfo.EMPTY;
  }

  //-------------------------------------------------------------------------
  @Override
  public DeliverableSwapFutureTrade resolveLinks(LinkResolver resolver) {
    return resolver.resolveLinksIn(this, securityLink, resolved -> toBuilder().securityLink(resolved).build());
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code DeliverableSwapFutureTrade}.
   * @return the meta-bean, not null
   */
  public static DeliverableSwapFutureTrade.Meta meta() {
    return DeliverableSwapFutureTrade.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(DeliverableSwapFutureTrade.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static DeliverableSwapFutureTrade.Builder builder() {
    return new DeliverableSwapFutureTrade.Builder();
  }

  private DeliverableSwapFutureTrade(
      TradeInfo tradeInfo,
      SecurityLink<DeliverableSwapFuture> securityLink,
      long quantity,
      double tradePrice) {
    JodaBeanUtils.notNull(securityLink, "securityLink");
    this.tradeInfo = tradeInfo;
    this.securityLink = securityLink;
    this.quantity = quantity;
    this.tradePrice = tradePrice;
  }

  @Override
  public DeliverableSwapFutureTrade.Meta metaBean() {
    return DeliverableSwapFutureTrade.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the additional trade information, defaulted to an empty instance.
   * <p>
   * This allows additional information to be attached to the trade.
   * @return the value of the property
   */
  @Override
  public TradeInfo getTradeInfo() {
    return tradeInfo;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the link to the future that was traded.
   * <p>
   * This property returns a link to the security via a {@link StandardId}.
   * See {@link #getSecurity()} and {@link SecurityLink} for more details.
   * @return the value of the property, not null
   */
  @Override
  public SecurityLink<DeliverableSwapFuture> getSecurityLink() {
    return securityLink;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the quantity, indicating the number of future contracts in the trade.
   * <p>
   * This will be positive if buying and negative if selling.
   * @return the value of the property
   */
  public long getQuantity() {
    return quantity;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the trade price of the future.
   * <p>
   * This is the transaction price expressed in the convention of the futures.
   * @return the value of the property
   */
  public double getTradePrice() {
    return tradePrice;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      DeliverableSwapFutureTrade other = (DeliverableSwapFutureTrade) obj;
      return JodaBeanUtils.equal(getTradeInfo(), other.getTradeInfo()) &&
          JodaBeanUtils.equal(getSecurityLink(), other.getSecurityLink()) &&
          (getQuantity() == other.getQuantity()) &&
          JodaBeanUtils.equal(getTradePrice(), other.getTradePrice());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getTradeInfo());
    hash = hash * 31 + JodaBeanUtils.hashCode(getSecurityLink());
    hash = hash * 31 + JodaBeanUtils.hashCode(getQuantity());
    hash = hash * 31 + JodaBeanUtils.hashCode(getTradePrice());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(160);
    buf.append("DeliverableSwapFutureTrade{");
    buf.append("tradeInfo").append('=').append(getTradeInfo()).append(',').append(' ');
    buf.append("securityLink").append('=').append(getSecurityLink()).append(',').append(' ');
    buf.append("quantity").append('=').append(getQuantity()).append(',').append(' ');
    buf.append("tradePrice").append('=').append(JodaBeanUtils.toString(getTradePrice()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code DeliverableSwapFutureTrade}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code tradeInfo} property.
     */
    private final MetaProperty<TradeInfo> tradeInfo = DirectMetaProperty.ofImmutable(
        this, "tradeInfo", DeliverableSwapFutureTrade.class, TradeInfo.class);
    /**
     * The meta-property for the {@code securityLink} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<SecurityLink<DeliverableSwapFuture>> securityLink = DirectMetaProperty.ofImmutable(
        this, "securityLink", DeliverableSwapFutureTrade.class, (Class) SecurityLink.class);
    /**
     * The meta-property for the {@code quantity} property.
     */
    private final MetaProperty<Long> quantity = DirectMetaProperty.ofImmutable(
        this, "quantity", DeliverableSwapFutureTrade.class, Long.TYPE);
    /**
     * The meta-property for the {@code tradePrice} property.
     */
    private final MetaProperty<Double> tradePrice = DirectMetaProperty.ofImmutable(
        this, "tradePrice", DeliverableSwapFutureTrade.class, Double.TYPE);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "tradeInfo",
        "securityLink",
        "quantity",
        "tradePrice");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 752580658:  // tradeInfo
          return tradeInfo;
        case 807992154:  // securityLink
          return securityLink;
        case -1285004149:  // quantity
          return quantity;
        case 1861750341:  // tradePrice
          return tradePrice;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public DeliverableSwapFutureTrade.Builder builder() {
      return new DeliverableSwapFutureTrade.Builder();
    }

    @Override
    public Class<? extends DeliverableSwapFutureTrade> beanType() {
      return DeliverableSwapFutureTrade.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code tradeInfo} property.
     * @return the meta-property, not null
     */
    public MetaProperty<TradeInfo> tradeInfo() {
      return tradeInfo;
    }

    /**
     * The meta-property for the {@code securityLink} property.
     * @return the meta-property, not null
     */
    public MetaProperty<SecurityLink<DeliverableSwapFuture>> securityLink() {
      return securityLink;
    }

    /**
     * The meta-property for the {@code quantity} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Long> quantity() {
      return quantity;
    }

    /**
     * The meta-property for the {@code tradePrice} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Double> tradePrice() {
      return tradePrice;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 752580658:  // tradeInfo
          return ((DeliverableSwapFutureTrade) bean).getTradeInfo();
        case 807992154:  // securityLink
          return ((DeliverableSwapFutureTrade) bean).getSecurityLink();
        case -1285004149:  // quantity
          return ((DeliverableSwapFutureTrade) bean).getQuantity();
        case 1861750341:  // tradePrice
          return ((DeliverableSwapFutureTrade) bean).getTradePrice();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code DeliverableSwapFutureTrade}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<DeliverableSwapFutureTrade> {

    private TradeInfo tradeInfo;
    private SecurityLink<DeliverableSwapFuture> securityLink;
    private long quantity;
    private double tradePrice;

    /**
     * Restricted constructor.
     */
    private Builder() {
      applyDefaults(this);
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(DeliverableSwapFutureTrade beanToCopy) {
      this.tradeInfo = beanToCopy.getTradeInfo();
      this.securityLink = beanToCopy.getSecurityLink();
      this.quantity = beanToCopy.getQuantity();
      this.tradePrice = beanToCopy.getTradePrice();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 752580658:  // tradeInfo
          return tradeInfo;
        case 807992154:  // securityLink
          return securityLink;
        case -1285004149:  // quantity
          return quantity;
        case 1861750341:  // tradePrice
          return tradePrice;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 752580658:  // tradeInfo
          this.tradeInfo = (TradeInfo) newValue;
          break;
        case 807992154:  // securityLink
          this.securityLink = (SecurityLink<DeliverableSwapFuture>) newValue;
          break;
        case -1285004149:  // quantity
          this.quantity = (Long) newValue;
          break;
        case 1861750341:  // tradePrice
          this.tradePrice = (Double) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public DeliverableSwapFutureTrade build() {
      return new DeliverableSwapFutureTrade(
          tradeInfo,
          securityLink,
          quantity,
          tradePrice);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the additional trade information, defaulted to an empty instance.
     * <p>
     * This allows additional information to be attached to the trade.
     * @param tradeInfo  the new value
     * @return this, for chaining, not null
     */
    public Builder tradeInfo(TradeInfo tradeInfo) {
      this.tradeInfo = tradeInfo;
      return this;
    }

    /**
     * Sets the link to the future that was traded.
     * <p>
     * This property returns a link to the security via a {@link StandardId}.
     * See {@link #getSecurity()} and {@link SecurityLink} for more details.
     * @param securityLink  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder securityLink(SecurityLink<DeliverableSwapFuture> securityLink) {
      JodaBeanUtils.notNull(securityLink, "securityLink");
      this.securityLink = securityLink;
      return this;
    }

    /**
     * Sets the quantity, indicating the number of future contracts in the trade.
     * <p>
     * This will be positive if buying and negative if selling.
     * @param quantity  the new value
     * @return this, for chaining, not null
     */
    public Builder quantity(long quantity) {
      this.quantity = quantity;
      return this;
    }

    /**
     * Sets the trade price of the future.
     * <p>
     * This is the transaction price expressed in the convention of the futures.
     * @param tradePrice  the new value
     * @return this, for chaining, not null
     */
    public Builder tradePrice(double tradePrice) {
      this.tradePrice = tradePrice;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(160);
      buf.append("DeliverableSwapFutureTrade.Builder{");
      buf.append("tradeInfo").append('=').append(JodaBeanUtils.toString(tradeInfo)).append(',').append(' ');
      buf.append("securityLink").append('=').append(JodaBeanUtils.toString(securityLink)).append(',').append(' ');
      buf.append("quantity").append('=').append(JodaBeanUtils.toString(quantity)).append(',').append(' ');
      buf.append("tradePrice").append('=').append(JodaBeanUtils.toString(tradePrice));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
