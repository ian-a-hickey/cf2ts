/*
    Slatwall - An Open Source eCommerce Platform
    Copyright (C) ten24, LLC
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    Linking this program statically or dynamically with other modules is
    making a combined work based on this program.  Thus, the terms and
    conditions of the GNU General Public License cover the whole
    combination.
    As a special exception, the copyright holders of this program give you
    permission to combine this program with independent modules and your 
    custom code, regardless of the license terms of these independent
    modules, and to copy and distribute the resulting program under terms 
    of your choice, provided that you follow these specific guidelines: 
	- You also meet the terms and conditions of the license of each 
	  independent module 
	- You must not alter the default display of the Slatwall name or logo from  
	  any part of the application 
	- Your custom code must not alter or create any files inside Slatwall, 
	  except in the following directories:
		/integrationServices/
	You may copy and distribute the modified version of this program that meets 
	the above guidelines as a combined work under the terms of GPL for this program, 
	provided that you include the source code of that other code when and as the 
	GNU GPL requires distribution of source code.
    If you modify this program, you may extend this exception to your version 
    of the program, but you are not obligated to do so.
property name="commentproductID" ormtype="string" length="32" fieldtype="id" generator="uuid" unsavedvalue="" default="";
Notes:
*/
/**
	*@description This Product class was generated using the cfc component located in /Slatwall/model/entity
  	*@displayname "Product"
 	*@entityname "SlatwallProduct"
  	*@table "SWProduct"
  	*@persistent "true"
 	*@accessors "true"
 	*@extends "HibachiEntity"
 	*@cacheuse "transactional"
 	*@hb_serviceName "productService"
 	*@hb_permission "this"
 	*@hb_processContexts "addOptionGroup,addOption,addSubscriptionSku,deleteDefaultImage,updateDefaultImageFileNames,updateSkus,addProductReview"
*/
module slatwall { 
    class Product {
	/**
 	*@name "productID"
 	*@ormtype "string"
 	*@length "32"
 	*@fieldtype "id"
 	*@generator "uuid"
 	*@unsavedvalue ""
 	*@default ""
	*/
	private productID: any;
	/**
 	*@name "activeFlag"
 	*@ormtype "boolean"
	*/
	private  activeFlag: boolean;
	/**
 	*@name "urlTitle"
 	*@ormtype "string"
 	*@unique "true"
	*/
	private  urlTitle: string;
	/**
 	*@name "productName"
 	*@ormtype "string"
 	*@notNull "true"
	*/
	private  productName: string;
	/**
 	*@name "productCode"
 	*@ormtype "string"
 	*@unique "true"
 	*@index "PI_PRODUCTCODE"
	*/
	private  productCode: string;
	/**
 	*@name "productDescription"
 	*@ormtype "string"
 	*@length "4000"
 	*@hb_formFieldType "wysiwyg"
	*/
	private productDescription: any;
	/**
 	*@name "publishedFlag"
 	*@ormtype "boolean"
 	*@default "false"
	*/
	private  publishedFlag: boolean;
	/**
 	*@name "sortOrder"
 	*@ormtype "integer"
	*/
	private sortOrder: number;
	/**
 	*@name "purchaseStartDateTime"
 	*@ormtype "timestamp"
	*/
	private  purchaseStartDateTime: string;
	/**
 	*@name "purchaseEndDateTime"
 	*@ormtype "timestamp"
	*/
	private  purchaseEndDateTime: string;
	/**
 	*@name "calculatedSalePrice"
 	*@ormtype "big_decimal"
	*/
	private calculatedSalePrice: number;
	/**
 	*@name "calculatedQATS"
 	*@ormtype "integer"
	*/
	private calculatedQATS: number;
	/**
 	*@name "calculatedAllowBackorderFlag"
 	*@ormtype "boolean"
	*/
	private  calculatedAllowBackorderFlag: boolean;
	/**
 	*@name "calculatedTitle"
 	*@ormtype "string"
	*/
	private  calculatedTitle: string;
	/**
 	*@name "brand"
 	*@cfc "Brand"
 	*@fieldtype "many-to-one"
 	*@fkcolumn "brandID"
 	*@hb_optionsNullRBKey "define.none"
 	*@fetch "join"
	*/
	private brand: any;
	/**
 	*@name "productType"
 	*@cfc "ProductType"
 	*@fieldtype "many-to-one"
 	*@fkcolumn "productTypeID"
 	*@fetch "join"
	*/
	private productType: any;
	/**
 	*@name "defaultSku"
 	*@cfc "Sku"
 	*@fieldtype "many-to-one"
 	*@fkcolumn "defaultSkuID"
 	*@cascade "delete"
 	*@fetch "join"
	*/
	private defaultSku: any;
	/**
 	*@name "skus"
 	*@type "array"
 	*@cfc "Sku"
 	*@singularname "sku"
 	*@fieldtype "one-to-many"
 	*@fkcolumn "productID"
 	*@cascade "all-delete-orphan"
 	*@inverse "true"
	*/
	private skus: any[];
	/**
 	*@name "productImages"
 	*@type "array"
 	*@cfc "Image"
 	*@singularname "productImage"
 	*@fieldtype "one-to-many"
 	*@fkcolumn "productID"
 	*@cascade "all-delete-orphan"
 	*@inverse "true"
	*/
	private productImages: any[];
	/**
 	*@name "attributeValues"
 	*@singularname "attributeValue"
 	*@cfc "AttributeValue"
 	*@fieldtype "one-to-many"
 	*@fkcolumn "productID"
 	*@cascade "all-delete-orphan"
 	*@inverse "true"
	*/
	private attributeValues: any[];
	/**
 	*@name "productReviews"
 	*@singularname "productReview"
 	*@cfc "ProductReview"
 	*@fieldtype "one-to-many"
 	*@fkcolumn "productID"
 	*@cascade "all-delete-orphan"
 	*@inverse "true"
	*/
	private productReviews: any[];
	/**
 	*@name "productSchedules"
 	*@singularName "productSchedule"
 	*@cfc "ProductSchedule"
 	*@fieldtype "one-to-many"
 	*@fkcolumn "productID"
 	*@cascade "all-delete-orphan"
 	*@inverse "true"
	*/
	private productSchedules: any[];
	/**
 	*@name "listingPages"
 	*@singularname "listingPage"
 	*@cfc "Content"
 	*@fieldtype "many-to-many"
 	*@linktable "SwProductListingPage"
 	*@fkcolumn "productID"
 	*@inversejoincolumn "contentID"
	*/
	private listingPage: any[];
	/**
 	*@name "categories"
 	*@singularname "category"
 	*@cfc "Category"
 	*@fieldtype "many-to-many"
 	*@linktable "SwProductCategory"
 	*@fkcolumn "productID"
 	*@inversejoincolumn "categoryID"
	*/
	private category: any[];
	/**
 	*@name "relatedProducts"
 	*@singularname "relatedProduct"
 	*@cfc "Product"
 	*@type "array"
 	*@fieldtype "many-to-many"
 	*@linktable "SwRelatedProduct"
 	*@fkcolumn "productID"
 	*@inversejoincolumn "relatedProductID"
	*/
	private relatedProduct: any[];
	/**
 	*@name "promotionRewards"
 	*@singularname "promotionReward"
 	*@cfc "PromotionReward"
 	*@fieldtype "many-to-many"
 	*@linktable "SwPromoRewardProduct"
 	*@fkcolumn "productID"
 	*@inversejoincolumn "promotionRewardID"
 	*@inverse "true"
	*/
	private promotionReward: any[];
	/**
 	*@name "promotionRewardExclusions"
 	*@singularname "promotionRewardExclusion"
 	*@cfc "PromotionReward"
 	*@type "array"
 	*@fieldtype "many-to-many"
 	*@linktable "SwPromoRewardExclProduct"
 	*@fkcolumn "productID"
 	*@inversejoincolumn "promotionRewardID"
 	*@inverse "true"
	*/
	private promotionRewardExclusion: any[];
	/**
 	*@name "promotionQualifiers"
 	*@singularname "promotionQualifier"
 	*@cfc "PromotionQualifier"
 	*@fieldtype "many-to-many"
 	*@linktable "SwPromoQualProduct"
 	*@fkcolumn "productID"
 	*@inversejoincolumn "promotionQualifierID"
 	*@inverse "true"
	*/
	private promotionQualifier: any[];
	/**
 	*@name "promotionQualifierExclusions"
 	*@singularname "promotionQualifierExclusion"
 	*@cfc "PromotionQualifier"
 	*@type "array"
 	*@fieldtype "many-to-many"
 	*@linktable "SwPromoQualExclProduct"
 	*@fkcolumn "productID"
 	*@inversejoincolumn "promotionQualifierID"
 	*@inverse "true"
	*/
	private promotionQualifierExclusion: any[];
	/**
 	*@name "loyaltyAccruements"
 	*@singularname "loyaltyAccruement"
 	*@cfc "LoyaltyAccruement"
 	*@fieldtype "many-to-many"
 	*@linktable "SwLoyaltyAccruProduct"
 	*@fkcolumn "productID"
 	*@inversejoincolumn "loyaltyAccruementID"
 	*@inverse "true"
	*/
	private loyaltyAccruement: any[];
	/**
 	*@name "loyaltyAccruementExclusions"
 	*@singularname "loyaltyAccruementExclusion"
 	*@cfc "LoyaltyAccruement"
 	*@type "array"
 	*@fieldtype "many-to-many"
 	*@linktable "SwLoyaltyAccruExclProduct"
 	*@fkcolumn "productID"
 	*@inversejoincolumn "loyaltyAccruementID"
 	*@inverse "true"
	*/
	private loyaltyAccruementExclusion: any[];
	/**
 	*@name "loyaltyRedemptions"
 	*@singularname "loyaltyRedemption"
 	*@cfc "LoyaltyRedemption"
 	*@type "array"
 	*@fieldtype "many-to-many"
 	*@linktable "SwLoyaltyRedemptionProduct"
 	*@fkcolumn "productID"
 	*@inversejoincolumn "loyaltyRedemptionID"
 	*@inverse "true"
	*/
	private loyaltyRedemption: any[];
	/**
 	*@name "loyaltyRedemptionExclusions"
 	*@singularname "loyaltyRedemptionExclusion"
 	*@cfc "LoyaltyRedemption"
 	*@type "array"
 	*@fieldtype "many-to-many"
 	*@linktable "SwLoyaltyRedempExclProduct"
 	*@fkcolumn "productID"
 	*@inversejoincolumn "loyaltyRedemptionID"
 	*@inverse "true"
	*/
	private loyaltyRedemptionExclusion: any[];
	/**
 	*@name "priceGroupRates"
 	*@singularname "priceGroupRate"
 	*@cfc "PriceGroupRate"
 	*@fieldtype "many-to-many"
 	*@linktable "SwPriceGroupRateProduct"
 	*@fkcolumn "productID"
 	*@inversejoincolumn "priceGroupRateID"
 	*@inverse "true"
	*/
	private priceGroupRate: any[];
	/**
 	*@name "vendors"
 	*@singularname "vendor"
 	*@cfc "Vendor"
 	*@type "array"
 	*@fieldtype "many-to-many"
 	*@linktable "SwVendorProduct"
 	*@fkcolumn "productID"
 	*@inversejoincolumn "vendorID"
 	*@inverse "true"
	*/
	private vendor: any[];
	/**
 	*@name "physicals"
 	*@singularname "physical"
 	*@cfc "Physical"
 	*@type "array"
 	*@fieldtype "many-to-many"
 	*@linktable "SwPhysicalProduct"
 	*@fkcolumn "productID"
 	*@inversejoincolumn "physicalID"
 	*@inverse "true"
	*/
	private physical: any[];
	/**
 	*@name "remoteID"
 	*@ormtype "string"
	*/
	private  remoteID: string;
	/**
 	*@name "createdDateTime"
 	*@hb_populateEnabled "false"
 	*@ormtype "timestamp"
	*/
	private  createdDateTime: string;
	/**
 	*@name "createdByAccountID"
 	*@hb_populateEnabled "false"
 	*@ormtype "string"
	*/
	private  createdByAccountID: string;
	/**
 	*@name "modifiedDateTime"
 	*@hb_populateEnabled "false"
 	*@ormtype "timestamp"
	*/
	private  modifiedDateTime: string;
	/**
 	*@name "modifiedByAccountID"
 	*@hb_populateEnabled "false"
 	*@ormtype "string"
	*/
	private  modifiedByAccountID: string;
	/**
 	*@name "allowBackorderFlag"
 	*@type "boolean"
 	*@persistent "false"
	*/
	private  allowBackorderFlag: boolean;
	/**
 	*@name "availableForPurchaseFlag"
 	*@type "boolean"
 	*@persistent "false"
	*/
	private  availableForPurchaseFlag: boolean;
	/**
 	*@name "allowAddOptionGroupFlag"
 	*@type "boolean"
 	*@persistent "false"
	*/
	private  allowAddOptionGroupFlag: boolean;
	/**
 	*@name "baseProductType"
 	*@type "string"
 	*@persistent "false"
	*/
	private  baseProductType: string;
	/**
 	*@name "brandName"
 	*@type "string"
 	*@persistent "false"
	*/
	private  brandName: string;
	/**
 	*@name "brandOptions"
 	*@type "array"
 	*@persistent "false"
	*/
	private brandOptions: any[];
	/**
 	*@name "bundleSkusSmartList"
 	*@persistent "false"
	*/
	private bundleSkusSmartList: any;
	/**
 	*@name "estimatedReceivalDetails"
 	*@type "struct"
 	*@persistent "false"
	*/
	private estimatedReceivalDetails: any;
	/**
 	*@name "eventConflictExistsFlag"
 	*@type "boolean"
 	*@persistent "false"
	*/
	private  eventConflictExistsFlag: boolean;
	/**
 	*@name "eventRegistrations"
 	*@type "array"
 	*@persistent "false"
	*/
	private eventRegistrations: any[];
	/**
 	*@name "nextSkuCodeCount"
 	*@persistent "false"
	*/
	private nextSkuCodeCount: any;
	/**
 	*@name "optionGroupCount"
 	*@type "numeric"
 	*@persistent "false"
	*/
	private  optionGroupCount: number;
	/**
 	*@name "placedOrderItemsSmartList"
 	*@type "any"
 	*@persistent "false"
	*/
	private placedOrderItemsSmartList: any;
	/**
 	*@name "qats"
 	*@type "numeric"
 	*@persistent "false"
	*/
	private  qats: number;
	/**
 	*@name "salePriceDetailsForSkus"
 	*@type "struct"
 	*@persistent "false"
	*/
	private salePriceDetailsForSkus: any;
	/**
 	*@name "title"
 	*@type "string"
 	*@persistent "false"
	*/
	private  title: string;
	/**
 	*@name "transactionExistsFlag"
 	*@type "boolean"
 	*@persistent "false"
	*/
	private  transactionExistsFlag: boolean;
	/**
 	*@name "unusedProductOptions"
 	*@type "array"
 	*@persistent "false"
	*/
	private unusedProductOptions: any[];
	/**
 	*@name "unusedProductOptionGroups"
 	*@type "array"
 	*@persistent "false"
	*/
	private unusedProductOptionGroups: any[];
	/**
 	*@name "unusedProductSubscriptionTerms"
 	*@type "array"
 	*@persistent "false"
	*/
	private unusedProductSubscriptionTerms: any[];
	/**
 	*@name "currentAccountPrice"
 	*@hb_formatType "currency"
 	*@persistent "false"
	*/
	private currentAccountPrice: number;
	/**
 	*@name "currencyCode"
 	*@persistent "false"
	*/
	private currencyCode: any;
	/**
 	*@name "defaultProductImageFiles"
 	*@persistent "false"
	*/
	private defaultProductImageFiles: any;
	/**
 	*@name "price"
 	*@hb_formatType "currency"
 	*@persistent "false"
	*/
	private price: number;
	/**
 	*@name "renewalPrice"
 	*@hb_formatType "currency"
 	*@persistent "false"
	*/
	private renewalPrice: number;
	/**
 	*@name "listPrice"
 	*@hb_formatType "currency"
 	*@persistent "false"
	*/
	private listPrice: number;
	/**
 	*@name "livePrice"
 	*@hb_formatType "currency"
 	*@persistent "false"
	*/
	private livePrice: number;
	/**
 	*@name "salePrice"
 	*@hb_formatType "currency"
 	*@persistent "false"
	*/
	private salePrice: number;
	/**
 	*@name "schedulingOptions"
 	*@hb_formatType "array"
 	*@persistent "false"
	*/
	private schedulingOptions: any[];
	/** Getters and Setters */
	getUrlTitle():string { return this.urlTitle; }
	setUrlTitle(urlTitle:string) {this.urlTitle = urlTitle;}
	getPromotionQualifierExclusion():any[] { return this.promotionQualifierExclusion; }
	setPromotionQualifierExclusion(promotionQualifierExclusion:any[]) {this.promotionQualifierExclusion = promotionQualifierExclusion;}
	getProductImages():any[] { return this.productImages; }
	setProductImages(productImages:any[]) {this.productImages = productImages;}
	getPhysical():any[] { return this.physical; }
	setPhysical(physical:any[]) {this.physical = physical;}
	getDefaultProductImageFiles():any { return this.defaultProductImageFiles; }
	setDefaultProductImageFiles(defaultProductImageFiles:any) {this.defaultProductImageFiles = defaultProductImageFiles;}
	getCurrentAccountPrice():number { return this.currentAccountPrice; }
	setCurrentAccountPrice(currentAccountPrice:number) {this.currentAccountPrice = currentAccountPrice;}
	getProductDescription():any { return this.productDescription; }
	setProductDescription(productDescription:any) {this.productDescription = productDescription;}
	getLoyaltyRedemptionExclusion():any[] { return this.loyaltyRedemptionExclusion; }
	setLoyaltyRedemptionExclusion(loyaltyRedemptionExclusion:any[]) {this.loyaltyRedemptionExclusion = loyaltyRedemptionExclusion;}
	getPromotionReward():any[] { return this.promotionReward; }
	setPromotionReward(promotionReward:any[]) {this.promotionReward = promotionReward;}
	getBaseProductType():string { return this.baseProductType; }
	setBaseProductType(baseProductType:string) {this.baseProductType = baseProductType;}
	getBrandName():string { return this.brandName; }
	setBrandName(brandName:string) {this.brandName = brandName;}
	getProductType():any { return this.productType; }
	setProductType(productType:any) {this.productType = productType;}
	getCreatedByAccountID():string { return this.createdByAccountID; }
	setCreatedByAccountID(createdByAccountID:string) {this.createdByAccountID = createdByAccountID;}
	getListPrice():number { return this.listPrice; }
	setListPrice(listPrice:number) {this.listPrice = listPrice;}
	getModifiedByAccountID():string { return this.modifiedByAccountID; }
	setModifiedByAccountID(modifiedByAccountID:string) {this.modifiedByAccountID = modifiedByAccountID;}
	getUnusedProductOptions():any[] { return this.unusedProductOptions; }
	setUnusedProductOptions(unusedProductOptions:any[]) {this.unusedProductOptions = unusedProductOptions;}
	getCalculatedSalePrice():number { return this.calculatedSalePrice; }
	setCalculatedSalePrice(calculatedSalePrice:number) {this.calculatedSalePrice = calculatedSalePrice;}
	getUnusedProductSubscriptionTerms():any[] { return this.unusedProductSubscriptionTerms; }
	setUnusedProductSubscriptionTerms(unusedProductSubscriptionTerms:any[]) {this.unusedProductSubscriptionTerms = unusedProductSubscriptionTerms;}
	getEstimatedReceivalDetails():any { return this.estimatedReceivalDetails; }
	setEstimatedReceivalDetails(estimatedReceivalDetails:any) {this.estimatedReceivalDetails = estimatedReceivalDetails;}
	getPromotionQualifier():any[] { return this.promotionQualifier; }
	setPromotionQualifier(promotionQualifier:any[]) {this.promotionQualifier = promotionQualifier;}
	getLoyaltyAccruementExclusion():any[] { return this.loyaltyAccruementExclusion; }
	setLoyaltyAccruementExclusion(loyaltyAccruementExclusion:any[]) {this.loyaltyAccruementExclusion = loyaltyAccruementExclusion;}
	getSortOrder():number { return this.sortOrder; }
	setSortOrder(sortOrder:number) {this.sortOrder = sortOrder;}
	getNextSkuCodeCount():any { return this.nextSkuCodeCount; }
	setNextSkuCodeCount(nextSkuCodeCount:any) {this.nextSkuCodeCount = nextSkuCodeCount;}
	getCategory():any[] { return this.category; }
	setCategory(category:any[]) {this.category = category;}
	getPrice():number { return this.price; }
	setPrice(price:number) {this.price = price;}
	getEventConflictExistsFlag():boolean { return this.eventConflictExistsFlag; }
	setEventConflictExistsFlag(eventConflictExistsFlag:boolean) {this.eventConflictExistsFlag = eventConflictExistsFlag;}
	getBrandOptions():any[] { return this.brandOptions; }
	setBrandOptions(brandOptions:any[]) {this.brandOptions = brandOptions;}
	getCreatedDateTime():string { return this.createdDateTime; }
	setCreatedDateTime(createdDateTime:string) {this.createdDateTime = createdDateTime;}
	getSalePrice():number { return this.salePrice; }
	setSalePrice(salePrice:number) {this.salePrice = salePrice;}
	getSkus():any[] { return this.skus; }
	setSkus(skus:any[]) {this.skus = skus;}
	getPriceGroupRate():any[] { return this.priceGroupRate; }
	setPriceGroupRate(priceGroupRate:any[]) {this.priceGroupRate = priceGroupRate;}
	getDefaultSku():any { return this.defaultSku; }
	setDefaultSku(defaultSku:any) {this.defaultSku = defaultSku;}
	getSchedulingOptions():any[] { return this.schedulingOptions; }
	setSchedulingOptions(schedulingOptions:any[]) {this.schedulingOptions = schedulingOptions;}
	getBundleSkusSmartList():any { return this.bundleSkusSmartList; }
	setBundleSkusSmartList(bundleSkusSmartList:any) {this.bundleSkusSmartList = bundleSkusSmartList;}
	getProductReviews():any[] { return this.productReviews; }
	setProductReviews(productReviews:any[]) {this.productReviews = productReviews;}
	getQats():number { return this.qats; }
	setQats(qats:number) {this.qats = qats;}
	getProductSchedules():any[] { return this.productSchedules; }
	setProductSchedules(productSchedules:any[]) {this.productSchedules = productSchedules;}
	getAllowAddOptionGroupFlag():boolean { return this.allowAddOptionGroupFlag; }
	setAllowAddOptionGroupFlag(allowAddOptionGroupFlag:boolean) {this.allowAddOptionGroupFlag = allowAddOptionGroupFlag;}
	getProductID():any { return this.productID; }
	setProductID(productID:any) {this.productID = productID;}
	getAvailableForPurchaseFlag():boolean { return this.availableForPurchaseFlag; }
	setAvailableForPurchaseFlag(availableForPurchaseFlag:boolean) {this.availableForPurchaseFlag = availableForPurchaseFlag;}
	getPurchaseStartDateTime():string { return this.purchaseStartDateTime; }
	setPurchaseStartDateTime(purchaseStartDateTime:string) {this.purchaseStartDateTime = purchaseStartDateTime;}
	getPlacedOrderItemsSmartList():any { return this.placedOrderItemsSmartList; }
	setPlacedOrderItemsSmartList(placedOrderItemsSmartList:any) {this.placedOrderItemsSmartList = placedOrderItemsSmartList;}
	getTitle():string { return this.title; }
	setTitle(title:string) {this.title = title;}
	getLivePrice():number { return this.livePrice; }
	setLivePrice(livePrice:number) {this.livePrice = livePrice;}
	getEventRegistrations():any[] { return this.eventRegistrations; }
	setEventRegistrations(eventRegistrations:any[]) {this.eventRegistrations = eventRegistrations;}
	getActiveFlag():boolean { return this.activeFlag; }
	setActiveFlag(activeFlag:boolean) {this.activeFlag = activeFlag;}
	getTransactionExistsFlag():boolean { return this.transactionExistsFlag; }
	setTransactionExistsFlag(transactionExistsFlag:boolean) {this.transactionExistsFlag = transactionExistsFlag;}
	getRemoteID():string { return this.remoteID; }
	setRemoteID(remoteID:string) {this.remoteID = remoteID;}
	getLoyaltyRedemption():any[] { return this.loyaltyRedemption; }
	setLoyaltyRedemption(loyaltyRedemption:any[]) {this.loyaltyRedemption = loyaltyRedemption;}
	getRelatedProduct():any[] { return this.relatedProduct; }
	setRelatedProduct(relatedProduct:any[]) {this.relatedProduct = relatedProduct;}
	getAllowBackorderFlag():boolean { return this.allowBackorderFlag; }
	setAllowBackorderFlag(allowBackorderFlag:boolean) {this.allowBackorderFlag = allowBackorderFlag;}
	getUnusedProductOptionGroups():any[] { return this.unusedProductOptionGroups; }
	setUnusedProductOptionGroups(unusedProductOptionGroups:any[]) {this.unusedProductOptionGroups = unusedProductOptionGroups;}
	getCalculatedQATS():number { return this.calculatedQATS; }
	setCalculatedQATS(calculatedQATS:number) {this.calculatedQATS = calculatedQATS;}
	getCurrencyCode():any { return this.currencyCode; }
	setCurrencyCode(currencyCode:any) {this.currencyCode = currencyCode;}
	getProductCode():string { return this.productCode; }
	setProductCode(productCode:string) {this.productCode = productCode;}
	getPurchaseEndDateTime():string { return this.purchaseEndDateTime; }
	setPurchaseEndDateTime(purchaseEndDateTime:string) {this.purchaseEndDateTime = purchaseEndDateTime;}
	getVendor():any[] { return this.vendor; }
	setVendor(vendor:any[]) {this.vendor = vendor;}
	getListingPage():any[] { return this.listingPage; }
	setListingPage(listingPage:any[]) {this.listingPage = listingPage;}
	getSalePriceDetailsForSkus():any { return this.salePriceDetailsForSkus; }
	setSalePriceDetailsForSkus(salePriceDetailsForSkus:any) {this.salePriceDetailsForSkus = salePriceDetailsForSkus;}
	getPublishedFlag():boolean { return this.publishedFlag; }
	setPublishedFlag(publishedFlag:boolean) {this.publishedFlag = publishedFlag;}
	getAttributeValues():any[] { return this.attributeValues; }
	setAttributeValues(attributeValues:any[]) {this.attributeValues = attributeValues;}
	getCalculatedTitle():string { return this.calculatedTitle; }
	setCalculatedTitle(calculatedTitle:string) {this.calculatedTitle = calculatedTitle;}
	getCalculatedAllowBackorderFlag():boolean { return this.calculatedAllowBackorderFlag; }
	setCalculatedAllowBackorderFlag(calculatedAllowBackorderFlag:boolean) {this.calculatedAllowBackorderFlag = calculatedAllowBackorderFlag;}
	getPromotionRewardExclusion():any[] { return this.promotionRewardExclusion; }
	setPromotionRewardExclusion(promotionRewardExclusion:any[]) {this.promotionRewardExclusion = promotionRewardExclusion;}
	getBrand():any { return this.brand; }
	setBrand(brand:any) {this.brand = brand;}
	getModifiedDateTime():string { return this.modifiedDateTime; }
	setModifiedDateTime(modifiedDateTime:string) {this.modifiedDateTime = modifiedDateTime;}
	getProductName():string { return this.productName; }
	setProductName(productName:string) {this.productName = productName;}
	getLoyaltyAccruement():any[] { return this.loyaltyAccruement; }
	setLoyaltyAccruement(loyaltyAccruement:any[]) {this.loyaltyAccruement = loyaltyAccruement;}
	getRenewalPrice():number { return this.renewalPrice; }
	setRenewalPrice(renewalPrice:number) {this.renewalPrice = renewalPrice;}
	getOptionGroupCount():number { return this.optionGroupCount; }
	setOptionGroupCount(optionGroupCount:number) {this.optionGroupCount = optionGroupCount;}
    }//<--end class
}//<--end module
