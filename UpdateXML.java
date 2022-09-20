package com.kafka.sample.demo;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Service
public class UpdateXML {

	private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<FORMINFO UADVERSION=\"UAD Version 9/2011\" FORMNUM=\"1004\" FILENUM=\"52680108\" VENDOR=\"ALAMODE\" CASE_NO=\"\" FORMVERSION=\"3-2005\" MAINFORM=\"1004\" RenderFor=\"RAW\" ResultXmlSig=\"975C9BA7B2A8D6559A836A7F047F041046DB1FCA\" xmlns:fo=\"http://www.w3.org/1999/XSL/Format\">\r\n"
			+ "		<SUBJECT>\r\n"
			+ "			<ADDR>\r\n"
			+ "				<STREET>11642 Davenport Rd</STREET>\r\n"
			+ "				<CITY>Los Alamitos</CITY>\r\n"
			+ "				<STATEPROV>CA</STATEPROV>\r\n"
			+ "				<ZIP>90720</ZIP>\r\n"
			+ "				<GEOCODE>\r\n"
			+ "					<LATITUDE>33.79367</LATITUDE>\r\n"
			+ "					<LONGITUDE>-118.07229</LONGITUDE>\r\n"
			+ "				</GEOCODE>\r\n"
			+ "			</ADDR>\r\n"
			+ "			<LEGAL>\r\n"
			+ "				<DESCRIPTION>N-Tract: 1680 Block: Lot: 11</DESCRIPTION>\r\n"
			+ "			</LEGAL>\r\n"
			+ "			<COUNTY>Orange</COUNTY>\r\n"
			+ "			<ASSESPARCEL>\r\n"
			+ "				<NUM>086-082-11</NUM>\r\n"
			+ "			</ASSESPARCEL>\r\n"
			+ "			<TAXYEAR>2018</TAXYEAR>\r\n"
			+ "			<RETAXES>12,053</RETAXES>\r\n"
			+ "			<SPECIALASSESS>0</SPECIALASSESS>\r\n"
			+ "			<PROPRIGHTS>FEESIMPLE</PROPRIGHTS>\r\n"
			+ "			<PROPRIGHTSDESC/>\r\n"
			+ "			<MAPREF>11244</MAPREF>\r\n"
			+ "			<CENSUSTRACT>1100.06</CENSUSTRACT>\r\n"
			+ "			<BORROWER>Michael &amp; Ana Bitolas</BORROWER>\r\n"
			+ "			<CURRENTOWNER>Nguyen Huy Living Trust</CURRENTOWNER>\r\n"
			+ "			<CURRENTOCCUPANT>OWNER</CURRENTOCCUPANT>\r\n"
			+ "			<NBRHOODPROJNAME>Rossmoor</NBRHOODPROJNAME>\r\n"
			+ "			<PROJ>\r\n"
			+ "				<TYPE/>\r\n"
			+ "				<DESCRIPTION/>\r\n"
			+ "			</PROJ>\r\n"
			+ "			<HOMEOWNERASSNFEE>0</HOMEOWNERASSNFEE>\r\n"
			+ "			<HOMEOWNERASSNRESPONSE>PERMONTH</HOMEOWNERASSNRESPONSE>\r\n"
			+ "			<APPRAISAL>\r\n"
			+ "				<PURPOSE>\r\n"
			+ "					<RESPONSE>PURCHASE</RESPONSE>\r\n"
			+ "					<DESCRIPTION/>\r\n"
			+ "				</PURPOSE>\r\n"
			+ "			</APPRAISAL>\r\n"
			+ "			<SALES>\r\n"
			+ "				<PRICE>1,150,000</PRICE>\r\n"
			+ "				<DATE>06/17/2019</DATE>\r\n"
			+ "			</SALES>\r\n"
			+ "			<LOANCHARGE>\r\n"
			+ "				<RESPONSE>NO</RESPONSE>\r\n"
			+ "				<DESCRIPTION>$0;;</DESCRIPTION>\r\n"
			+ "			</LOANCHARGE>\r\n"
			+ "			<SOLDLISTED VALUE=\"YES\">\r\n"
			+ "				<PRICE>DOM 26;Subject was listed on 06/07/2019 for $1,189,000. It is in active status as of the effective date of this appraisal;CRMLS#PW19133402.</PRICE>\r\n"
			+ "			</SOLDLISTED>\r\n"
			+ "		</SUBJECT>\r\n"
			+ "		<ROOT>\r\n"
			+ "			<EXTERNAL_RULES>\r\n"
			+ "				<CONTENT>\r\n"
			+ "					<Transaction ID=\"{F5940D72-0EC8-40C7-A433-987AC4A9501D}\" BillableEvent=\"NO\" ErrorCode=\"Trx992\" ErrorMessage=\"MSG 992; Database query timeout exceeded;\" ResultMessage=\"\" StartTime=\"7/8/2019 7:37:18 PM\" EndTime=\"7/8/2019 7:37:55 PM\" TimeDuration=\"37.4543235\" Base=\"https://www.collateraldna.com/cdnarover/\" ASYNC=\"NO\" OADIInput=\"NO\" ConfigVersion=\"31\" ExpandHtml=\"False\" ExpandPdf=\"False\">\r\n"
			+ "						<RequestDetail RequestType=\"OADI\">\r\n"
			+ "							<RqCustomer/>\r\n"
			+ "							<RqUtr/>\r\n"
			+ "							<RqServiceID>SID_902A</RqServiceID>\r\n"
			+ "							<OwnerEstValue/>\r\n"
			+ "							<AsOfDate/>\r\n"
			+ "							<RqPropertyList>\r\n"
			+ "								<Property PropertyType=\"SUBJECT\">\r\n"
			+ "									<StreetAddress>11642 Davenport Rd</StreetAddress>\r\n"
			+ "									<City>Los Alamitos</City>\r\n"
			+ "									<State>CA</State>\r\n"
			+ "									<ZipCode>90720</ZipCode>\r\n"
			+ "								</Property>\r\n"
			+ "								<Property PropertyType=\"COMP1\">\r\n"
			+ "									<StreetAddress>11362 Davenport Rd</StreetAddress>\r\n"
			+ "									<City>Rossmoor</City>\r\n"
			+ "									<State>CA</State>\r\n"
			+ "									<ZipCode>90720</ZipCode>\r\n"
			+ "								</Property>\r\n"
			+ "								<Property PropertyType=\"COMP2\">\r\n"
			+ "									<StreetAddress>11611 Davenport Rd</StreetAddress>\r\n"
			+ "									<City>Rossmoor</City>\r\n"
			+ "									<State>CA</State>\r\n"
			+ "									<ZipCode>90720</ZipCode>\r\n"
			+ "								</Property>\r\n"
			+ "								<Property PropertyType=\"COMP3\">\r\n"
			+ "									<StreetAddress>11602 Weatherby Rd</StreetAddress>\r\n"
			+ "									<City>Rossmoor</City>\r\n"
			+ "									<State>CA</State>\r\n"
			+ "									<ZipCode>90720</ZipCode>\r\n"
			+ "								</Property>\r\n"
			+ "								<Property PropertyType=\"COMP4\">\r\n"
			+ "									<StreetAddress>3052 Druid Ln</StreetAddress>\r\n"
			+ "									<City>Rossmoor</City>\r\n"
			+ "									<State>CA</State>\r\n"
			+ "									<ZipCode>90720</ZipCode>\r\n"
			+ "								</Property>\r\n"
			+ "								<Property PropertyType=\"COMP5\">\r\n"
			+ "									<StreetAddress>3222 Yellowtail Dr</StreetAddress>\r\n"
			+ "									<City>Rossmoor</City>\r\n"
			+ "									<State>CA</State>\r\n"
			+ "									<ZipCode>90720</ZipCode>\r\n"
			+ "								</Property>\r\n"
			+ "							</RqPropertyList>\r\n"
			+ "							<RqFilterList/>\r\n"
			+ "						</RequestDetail>\r\n"
			+ "						<ResponseDetail>\r\n"
			+ "							<Service Item=\"1\" Display=\"YES\" DataSet=\"OADI Property Data\" Vendor=\"FNC\" ServiceType=\"Data\" ReportID=\"SID_715\" ReportType=\"Appraisal Validation Report\" BillableEvent=\"YES\" Result=\"HIT\" StartTime=\"7/8/2019 7:37:23 PM\" EndTime=\"7/8/2019 7:37:23 PM\" TimeDuration=\"0.0156255\" ResultMessage=\"Properties found.\" ServiceCode=\"1S0c0C5a5A\">\r\n"
			+ "								<ReportInfo>\r\n"
			+ "									<Property PropertyType=\"SUBJECT\" PropType=\"SUBJECT\" Item=\"0\" MatchFound=\"YES\" DataSource=\"NCD\" SourceOwner=\"FNC\" GeoCodeValid=\"YES\" GeoResultCode=\"H\" GeoSource=\"NCD\" DistanceFromSubject=\"0.00\" CurrentALTF=\"Y\" PriorALTF=\"Y\" MonthSinceLastRecording=\"\" FlipWarning=\"False\" Result=\"HIT\" ResultMessage=\"Property found;\" SearchTime=\"00:00:00.2031315\">\r\n"
			+ "										<StreetAddress>11642 DAVENPORT RD</StreetAddress>\r\n"
			+ "										<StreetNumber>11642</StreetNumber>\r\n"
			+ "										<StreetDirection/>\r\n"
			+ "										<StreetName>DAVENPORT</StreetName>\r\n"
			+ "										<StreetSuffix>RD</StreetSuffix>\r\n"
			+ "										<PostDirection/>\r\n"
			+ "										<UnitNumber/>\r\n"
			+ "										<City>LOS ALAMITOS</City>\r\n"
			+ "										<State>CA</State>\r\n"
			+ "										<ZipCode>90720</ZipCode>\r\n"
			+ "										<County>ORANGE</County>\r\n"
			+ "										<BaseRecId>726656</BaseRecId>\r\n"
			+ "										<FIPSCountyCode>6059</FIPSCountyCode>\r\n"
			+ "										<Latitude>33.793684</Latitude>\r\n"
			+ "										<Longitude>-118.072312</Longitude>\r\n"
			+ "										<DataType>Appraisal-Full</DataType>\r\n"
			+ "										<LastUpdateDate>7/5/2019</LastUpdateDate>\r\n"
			+ "										<Homeowner_Exp_Flag>YES</Homeowner_Exp_Flag>\r\n"
			+ "										<FuelType>Natural Gas</FuelType>\r\n"
			+ "										<PropertyRights>Fee Simple</PropertyRights>\r\n"
			+ "										<Utilities>Elec:Public / Gas:Public / Water:Public / Sanitary Sewer:Public / Storm Sew:Public</Utilities>\r\n"
			+ "										<GRMActual/>\r\n"
			+ "										<GRMEstimate/>\r\n"
			+ "										<VacantUnits/>\r\n"
			+ "										<Foundation>Slab / No / No Bsmt</Foundation>\r\n"
			+ "										<HOAMonthlyAmt/>\r\n"
			+ "										<AssessorLotSizeSqFt>7313</AssessorLotSizeSqFt>\r\n"
			+ "										<CurrentOwner FullName=\"HUY NGUYEN\">\r\n"
			+ "											<FirstName>HUY</FirstName>\r\n"
			+ "											<MiddleInit/>\r\n"
			+ "											<LastName>NGUYEN</LastName>\r\n"
			+ "										</CurrentOwner>\r\n"
			+ "										<Spouse FullName=\"\">\r\n"
			+ "											<FirstName/>\r\n"
			+ "											<MiddleInit/>\r\n"
			+ "											<LastName/>\r\n"
			+ "										</Spouse>\r\n"
			+ "										<SecondOwner FullName=\"\">\r\n"
			+ "											<FirstName/>\r\n"
			+ "											<MiddleInit/>\r\n"
			+ "											<LastName/>\r\n"
			+ "										</SecondOwner>\r\n"
			+ "										<SellerInfo FullName=\"VINCENT LAW\">\r\n"
			+ "											<FirstName>VINCENT</FirstName>\r\n"
			+ "											<MiddleInit/>\r\n"
			+ "											<LastName>LAW</LastName>\r\n"
			+ "										</SellerInfo>\r\n"
			+ "										<CountyName>ORANGE</CountyName>\r\n"
			+ "										<NeighborhoodProjectName/>\r\n"
			+ "										<CommunityName>LOS ALAMITOS</CommunityName>\r\n"
			+ "										<CensusTract>1100.06</CensusTract>\r\n"
			+ "										<MapReference>0796-J4</MapReference>\r\n"
			+ "										<AssessorParcelNum Standardized=\"868211\">086-082-11</AssessorParcelNum>\r\n"
			+ "										<LegalInfo>\r\n"
			+ "											<Tract>1680</Tract>\r\n"
			+ "											<Block/>\r\n"
			+ "											<Lot>11</Lot>\r\n"
			+ "											<Section/>\r\n"
			+ "											<Township/>\r\n"
			+ "											<Range/>\r\n"
			+ "											<Desc>N-TRACT: 1680 BLOCK: LOT: 11</Desc>\r\n"
			+ "										</LegalInfo>\r\n"
			+ "										<AssessedValues>\r\n"
			+ "											<Land>801226</Land>\r\n"
			+ "											<Improvements>149394</Improvements>\r\n"
			+ "											<Total>950620</Total>\r\n"
			+ "											<MarketValueLand/>\r\n"
			+ "											<MarketValueImprovements/>\r\n"
			+ "											<MarketValueTotal/>\r\n"
			+ "											<AppraisalValueLand/>\r\n"
			+ "											<AppraisalValueImprovements/>\r\n"
			+ "											<AppraisalValueTotal/>\r\n"
			+ "											<GrossLivingArea>1974</GrossLivingArea>\r\n"
			+ "										</AssessedValues>\r\n"
			+ "										<MarketValues>\r\n"
			+ "											<Land/>\r\n"
			+ "											<Improvements/>\r\n"
			+ "											<Total/>\r\n"
			+ "										</MarketValues>\r\n"
			+ "										<AppraisalValues>\r\n"
			+ "											<Land/>\r\n"
			+ "											<Improvements/>\r\n"
			+ "											<Total/>\r\n"
			+ "										</AppraisalValues>\r\n"
			+ "										<LandUse>RSFR</LandUse>\r\n"
			+ "										<LandUseDesc>Single Family Residence</LandUseDesc>\r\n"
			+ "										<AppraisalDate>9/1/1993</AppraisalDate>\r\n"
			+ "										<AgeOfAppraisal>26</AgeOfAppraisal>\r\n"
			+ "										<SalesDate Standardized=\"02/2017\">2/23/2017</SalesDate>\r\n"
			+ "										<SalesPrice>1040000</SalesPrice>\r\n"
			+ "										<PreviousSalesDate>7/10/2013</PreviousSalesDate>\r\n"
			+ "										<PreviousSalesPrice>900000</PreviousSalesPrice>\r\n"
			+ "										<LotSizeSqft>7313</LotSizeSqft>\r\n"
			+ "										<YearBuilt>1959</YearBuilt>\r\n"
			+ "										<GrossLivingArea>1974</GrossLivingArea>\r\n"
			+ "										<GrossBldgSqft>1448</GrossBldgSqft>\r\n"
			+ "										<AmenitiesPoolSpaDesc>Pool and Spa</AmenitiesPoolSpaDesc>\r\n"
			+ "										<ImprovementsOther/>\r\n"
			+ "										<SalesDateCommitted/>\r\n"
			+ "										<SalesPriceCommitted>0</SalesPriceCommitted>\r\n"
			+ "										<RecordingDocNum>76078</RecordingDocNum>\r\n"
			+ "										<DeedType>Deed</DeedType>\r\n"
			+ "										<LoanType>?</LoanType>\r\n"
			+ "										<FirstMortgageAmt>0</FirstMortgageAmt>\r\n"
			+ "										<FirstMortgageLender/>\r\n"
			+ "										<Bedrooms>4</Bedrooms>\r\n"
			+ "										<BathroomsTotal>3</BathroomsTotal>\r\n"
			+ "										<BathroomsFull>3</BathroomsFull>\r\n"
			+ "										<BathroomsHalf>0</BathroomsHalf>\r\n"
			+ "										<RoomsTotal>5</RoomsTotal>\r\n"
			+ "										<DesignStyle>Conventional</DesignStyle>\r\n"
			+ "										<YearBuiltEffective>1968</YearBuiltEffective>\r\n"
			+ "										<CoolingDesc>Central Air</CoolingDesc>\r\n"
			+ "										<HeatingDesc>Forced Air</HeatingDesc>\r\n"
			+ "										<CommunityPoolDesc>No</CommunityPoolDesc>\r\n"
			+ "										<FirePlaceNum>1</FirePlaceNum>\r\n"
			+ "										<BasementFinished>0</BasementFinished>\r\n"
			+ "										<ManufacturedHouse>No</ManufacturedHouse>\r\n"
			+ "										<ExteriorRoofSurface>Wood Shake</ExteriorRoofSurface>\r\n"
			+ "										<PropertyTaxAmt>10911.62</PropertyTaxAmt>\r\n"
			+ "										<TaxAssessorRollYear>2018</TaxAssessorRollYear>\r\n"
			+ "										<LotDimensions>103X71</LotDimensions>\r\n"
			+ "										<FloodZone FloodZoneFlag=\"NO\">X</FloodZone>\r\n"
			+ "										<FloodZoneMapNum>06059C0112J</FloodZoneMapNum>\r\n"
			+ "										<FloodZoneMapDate>12/3/2009</FloodZoneMapDate>\r\n"
			+ "										<NumUnits>0</NumUnits>\r\n"
			+ "										<ZoningDesc/>\r\n"
			+ "										<RentActualMonthly>0</RentActualMonthly>\r\n"
			+ "										<RentMarketMonthly>0</RentMarketMonthly>\r\n"
			+ "										<NumBldgs>1</NumBldgs>\r\n"
			+ "										<RentAreaNet>0</RentAreaNet>\r\n"
			+ "										<RentControl/>\r\n"
			+ "										<UtilitiesRent/>\r\n"
			+ "										<NumLevels>1</NumLevels>\r\n"
			+ "										<StoriesBldg>0</StoriesBldg>\r\n"
			+ "										<CondoCoopUnitLevel>0</CondoCoopUnitLevel>\r\n"
			+ "										<ConstructionQuality>Average</ConstructionQuality>\r\n"
			+ "										<ImprovementCondition>Average</ImprovementCondition>\r\n"
			+ "										<RemodeledInfo/>\r\n"
			+ "										<SiteInfluence>None</SiteInfluence>\r\n"
			+ "										<KitchenEquip>Range-oven / Disposal / Dishwasher / Fan Hood</KitchenEquip>\r\n"
			+ "										<BasementSqft>0</BasementSqft>\r\n"
			+ "										<CarsCovered>2</CarsCovered>\r\n"
			+ "										<CarsOffStreetOpen>0</CarsOffStreetOpen>\r\n"
			+ "										<FullPartial>Full Value</FullPartial>\r\n"
			+ "										<PricePerSqFt>527</PricePerSqFt>\r\n"
			+ "										<Age>60</Age>\r\n"
			+ "										<AttachedDetached>D</AttachedDetached>\r\n"
			+ "										<Comments>TRFC NO</Comments>\r\n"
			+ "										<AmenCommunityDesc/>\r\n"
			+ "										<ForSaleData CurrentlyForSale=\"YES\">\r\n"
			+ "											<Observation Date=\"6/27/2019\" Price=\"1189000\" ForSaleByOwner=\"False\"/>\r\n"
			+ "											<Observation Date=\"6/19/2019\" Price=\"1189000\" ForSaleByOwner=\"False\"/>\r\n"
			+ "											<Observation Date=\"6/11/2019\" Price=\"1189000\" ForSaleByOwner=\"False\"/>\r\n"
			+ "											<Observation Date=\"6/9/2019\" Price=\"1189000\" ForSaleByOwner=\"False\"/>\r\n"
			+ "										</ForSaleData>\r\n"
			+ "										<GeographicFeatureList Superfund=\"NO\"/>\r\n"
			+ "										<NeighborhoodName>Rossmoor</NeighborhoodName>\r\n"
			+ "										<SubdivisionName/>\r\n"
			+ "										<School Address=\"10821 OAK ST LOS ALAMITOS, CA\" Distance=\"0.86\" DistanceSpecified=\"True\" District=\"LOS ALAMITOS UNIFIED SCHOOL DISTRICT\" Enrollment=\"1058\" EnrollmentSpecified=\"True\" GradeMax=\"08\" GradeMin=\"06\" Name=\"OAK MIDDLE SCHOOL\" StudentTeacherRatio=\"29:1\" Levels=\"Middle\"/>\r\n"
			+ "										<School Address=\"11872 WEMBLEY RD LOS ALAMITOS, CA\" Distance=\"0.78\" DistanceSpecified=\"True\" District=\"LOS ALAMITOS UNIFIED SCHOOL DISTRICT\" Enrollment=\"711\" EnrollmentSpecified=\"True\" GradeMax=\"05\" GradeMin=\"KG\" Name=\"JACK L. WEAVER ELEMENTARY SCHOOL\" StudentTeacherRatio=\"26:1\" Levels=\"Primary\"/>\r\n"
			+ "										<School Address=\"3591 CERRITOS AVE LOS ALAMITOS, CA\" Distance=\"1.25\" DistanceSpecified=\"True\" District=\"LOS ALAMITOS UNIFIED SCHOOL DISTRICT\" Enrollment=\"3292\" EnrollmentSpecified=\"True\" GradeMax=\"12\" GradeMin=\"09\" Name=\"LOS ALAMITOS HIGH SCHOOL\" StudentTeacherRatio=\"29:1\" Levels=\"High School\"/>\r\n"
			+ "										<School Address=\"3272 SHAKESPEARE DR LOS ALAMITOS, CA\" Distance=\"0.27\" DistanceSpecified=\"True\" District=\"LOS ALAMITOS UNIFIED SCHOOL DISTRICT\" Enrollment=\"662\" EnrollmentSpecified=\"True\" GradeMax=\"05\" GradeMin=\"KG\" Name=\"ROSSMOOR ELEMENTARY SCHOOL\" StudentTeacherRatio=\"25:1\" Levels=\"Primary\"/>\r\n"
			+ "										<School Address=\"10291 BLOOMFIELD ST LOS ALAMITOS, CA\" Distance=\"1.62\" DistanceSpecified=\"True\" District=\"LOS ALAMITOS UNIFIED SCHOOL DISTRICT\" Enrollment=\"0\" EnrollmentSpecified=\"True\" GradeMax=\"12\" GradeMin=\"09\" Name=\"LAUREL HIGH SCHOOL (CONTINUATION)\" StudentTeacherRatio=\"\" Levels=\"High School\"/>\r\n"
			+ "										<School Address=\"3591 ORANGEWOOD AVE LOS ALAMITOS, CA\" Distance=\"0.19\" DistanceSpecified=\"True\" District=\"Private\" Enrollment=\"445\" EnrollmentSpecified=\"True\" GradeMax=\"08\" GradeMin=\"KG\" Name=\"ST HEDWIG CATHOLIC SCHOOL\" StudentTeacherRatio=\"21:1\" Levels=\"Elementary\"/>\r\n"
			+ "										<School Address=\"4001 HOWARD AVE LOS ALAMITOS, CA\" Distance=\"0.73\" DistanceSpecified=\"True\" District=\"Private\" Enrollment=\"2\" EnrollmentSpecified=\"True\" GradeMax=\"KG\" GradeMin=\"PK\" Name=\"MONTESSORI GREENHOUSE SCHOOLS\" StudentTeacherRatio=\"1:1\" Levels=\"Elementary\"/>\r\n"
			+ "										<School Address=\"22427 NORWALK BLVD HAWAIIAN GARDENS, CA\" Distance=\"2.14\" DistanceSpecified=\"True\" District=\"Private\" Enrollment=\"38\" EnrollmentSpecified=\"True\" GradeMax=\"12\" GradeMin=\"07\" Name=\"TURNER CHRISTIAN HIGH SCHOOL\" StudentTeacherRatio=\"7:1\" Levels=\"Secondary\"/>\r\n"
			+ "										<School Address=\"5400 MYRA AVE CYPRESS, CA\" Distance=\"2.4\" DistanceSpecified=\"True\" District=\"Private\" Enrollment=\"50\" EnrollmentSpecified=\"True\" GradeMax=\"12\" GradeMin=\"07\" Name=\"ALTON SCHOOL\" StudentTeacherRatio=\"9:1\" Levels=\"Secondary\"/>\r\n"
			+ "										<School Address=\"4111 KATELLA AVE LOS ALAMITOS, CA\" Distance=\"0.96\" DistanceSpecified=\"True\" District=\"Private\" Enrollment=\"76\" EnrollmentSpecified=\"True\" GradeMax=\"PK\" GradeMin=\"PK\" Name=\"MAYFLOWER PRESCHOOL\" StudentTeacherRatio=\"13:1\" Levels=\"Other/Mixed Grades\"/>\r\n"
			+ "										<School Address=\"14401 WILLOW LN HUNTINGTON BEACH, CA\" Distance=\"4.12\" DistanceSpecified=\"True\" District=\"Private\" Enrollment=\"220\" EnrollmentSpecified=\"True\" GradeMax=\"12\" GradeMin=\"PK\" Name=\"HEBREW ACADEMY\" StudentTeacherRatio=\"6:1\" Levels=\"Other/Mixed Grades\"/>\r\n"
			+ "										<LastSalesDateClosing>8/24/2018</LastSalesDateClosing>\r\n"
			+ "										<LastSalesPriceClosing>0</LastSalesPriceClosing>\r\n"
			+ "										<LastRecordingDocNum>311297</LastRecordingDocNum>\r\n"
			+ "										<LastDeedtype>Deed</LastDeedtype>\r\n"
			+ "										<StreetViewUrl/>\r\n"
			+ "										<MSA>31080</MSA>\r\n"
			+ "										<EnergyEfficientItems Code=\"NNNNNNNNN\"/>\r\n"
			+ "										<FoundationWalls Code=\"O\">Concrete</FoundationWalls>\r\n"
			+ "										<ExteriorWalls Code=\"C\">Stucco</ExteriorWalls>\r\n"
			+ "										<GuttersDownspouts Code=\"\"/>\r\n"
			+ "										<WindowType Code=\"S\">Sliding Aluminum</WindowType>\r\n"
			+ "										<StormSashScreens Code=\"Y\">Yes</StormSashScreens>\r\n"
			+ "										<Fence>False</Fence>\r\n"
			+ "										<PorchPatioDeck>PATIO</PorchPatioDeck>\r\n"
			+ "										<CarStorage Code=\"\"/>\r\n"
			+ "										<DrivewaySurface Code=\"C\">Concrete</DrivewaySurface>\r\n"
			+ "										<CarStorageType/>\r\n"
			+ "										<LotShape/>\r\n"
			+ "										<ZoningCompliance Code=\"Y\">Legal</ZoningCompliance>\r\n"
			+ "										<CarStorageSqFt/>\r\n"
			+ "										<EasementApparent Code=\"T\">Typical Utilities</EasementApparent>\r\n"
			+ "										<MMI>1</MMI>\r\n"
			+ "										<AssrAboveFinishedSqFt>1974</AssrAboveFinishedSqFt>\r\n"
			+ "										<FirePlaceType Code=\"B\">Brick</FirePlaceType>\r\n"
			+ "										<Landscaping Code=\"A\">Adequate</Landscaping>\r\n"
			+ "										<OffsiteImprovements Code=\"AUCUCUYUN\">Asphalt / Public / Concrete / Public / Concrete / Public / Public / None</OffsiteImprovements>\r\n"
			+ "										<ApprAboveFinishedSqFt/>\r\n"
			+ "										<EstLifeRemaining/>\r\n"
			+ "										<Location>A;BCKS BUSY ST;</Location>\r\n"
			+ "										<BuildUp/>\r\n"
			+ "										<Growth/>\r\n"
			+ "										<AvgValueNeighborhood/>\r\n"
			+ "										<AvgPricePerSqFtNeighborhood/>\r\n"
			+ "										<NeighborhoodValuePercentChange/>\r\n"
			+ "										<BasementOutsideEntry>No</BasementOutsideEntry>\r\n"
			+ "										<Foreclosure Event=\"NO\" Tier=\"\" Date=\"\" Description=\"\" Type=\"NO\"/>\r\n"
			+ "									</Property>\r\n"
			+ "								</ReportInfo>\r\n"
			+ "							</Service>\r\n"
			+ "							<Service Item=\"2\" Display=\"YES\" DataSet=\"OADI Property Data\" Vendor=\"FNC\" ServiceType=\"Analytic\" ReportID=\"SID_704\" ReportType=\"Area Homogeneity and Conformity Score Report\" BillableEvent=\"YES\" Result=\"HIT\" StartTime=\"7/8/2019 7:37:23 PM\" EndTime=\"7/8/2019 7:37:23 PM\" TimeDuration=\"0\" ResultMessage=\"Calculation successful.\" test=\"6\">\r\n"
			+ "								<ReportInfo>\r\n"
			+ "									<ModelResults>\r\n"
			+ "										<Model Type=\"Combined\" Result=\"HIT\" StatusMessage=\"Calculation Successful;\">\r\n"
			+ "											<Score Type=\"Homogeneity\" ScoreMinValue=\"0\" ScoreMaxValue=\"100\" SummaryScore=\"3\" SummaryText=\"High\" StatusMessage=\"Calculation Successful;\" Gauge=\"https://www.collateraldna.com/cdnarover/images/Gauge_High.png\">79</Score>\r\n"
			+ "											<Score Type=\"Conformity\" ScoreMinValue=\"0\" ScoreMaxValue=\"100\" SummaryScore=\"3\" SummaryText=\"High\" NonConforming=\"NO\" NonConformingReason=\"\" StatusMessage=\"Calculation Successful;\" Gauge=\"https://www.collateraldna.com/cdnarover/images/Gauge_High.png\">64</Score>\r\n"
			+ "										</Model>\r\n"
			+ "									</ModelResults>\r\n"
			+ "								</ReportInfo>\r\n"
			+ "							</Service>\r\n"
			+ "						</ResponseDetail>\r\n"
			+ "					</Transaction>\r\n"
			+ "				</CONTENT>\r\n"
			+ "			</EXTERNAL_RULES>\r\n"
			+ "		</ROOT>\r\n"
			+ "	</FORMINFO>";
	
	public void send(String input){
		
		try {
            //String remElement = "ROOT";
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(XML.getBytes("UTF-8")));
            
            Document target = builder.parse(new ByteArrayInputStream(XML.getBytes("UTF-8")));
            //Element formInfo = target.createElement("FORMINFO1");
            NodeList tarList = target.getElementsByTagName("FORMINFO");
            Node tarNode = tarList.item(0);
            Document tarDocument = tarNode.getOwnerDocument();
            
            
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer tFormer = tFactory.newTransformer();
            //Element element = (Element) doc.getElementsByTagName(remElement).item(0);
            //Element formInfo = doc.createElement("FORMINFO");
            NodeList lt = doc.getElementsByTagName("Transaction");
            
            /*for (int i = 0; i < lt.getLength(); i++) {
                // get first staff
                Node t = lt.item(i);
                if (t.getNodeType() == Node.ELEMENT_NODE) {
                    String id = t.getNodeName();
                    if ("Transaction".equals(id.trim())) {

                            NodeList childNodes = t.getChildNodes();

                            for (int j = 0; j < childNodes.getLength(); j++) {
                                Node item = childNodes.item(j);
                                if ("RequestDetail".equalsIgnoreCase(item.getNodeName())) {
                              
                                	Node resultRequest = tarDocument.importNode(item, true);
                                    tarNode.appendChild(resultRequest);
                                } else if ("ResponseDetail".equalsIgnoreCase(item.getNodeName())) {
                              
                                	Node resultResponse = tarDocument.importNode(item, true);
                                    tarNode.appendChild(resultResponse);
                                }
                                if (item.getNodeType() == Node.ELEMENT_NODE) {

                                    if ("RequestDetail".equalsIgnoreCase(item.getNodeName())) {
                                    	Node RequestDetail = item;
                                    	Node resultRequest = tarDocument.importNode(RequestDetail, true);
                                        tarNode.appendChild(resultRequest);
                                    } else if ("ResponseDetail".equalsIgnoreCase(item.getNodeName())) {
                                    	Node ResponseDetail = item;
                                    	Node resultResponse = tarDocument.importNode(ResponseDetail, true);
                                        tarNode.appendChild(resultResponse);
                                    }
                                    }
                            }
                    }
                    }
            }*/
            NodeList requestDetailList = doc.getElementsByTagName("RequestDetail");
            NodeList ResponseDetailList = doc.getElementsByTagName("ResponseDetail");
     
            Node requestNode = requestDetailList.item(0);
            Node ResponseNode = ResponseDetailList.item(0);
            
            //formInfo.appendChild(RequestDetail);
            //formInfo.appendChild(ResponseDetail);
                                   
            
            Node resultRequest = tarDocument.importNode(requestNode, true);
            //tarNode.appendChild(resultRequest);
            Node resultResponse = tarDocument.importNode(ResponseNode, true);
            
            Element formInfo = target.createElement("FORMINFO1");
            formInfo.appendChild(resultRequest);
            formInfo.appendChild(resultResponse);
            
            tarNode.appendChild(formInfo);
            
            
            //element.getParentNode().removeChild(element);
            
            doc.normalize();
            Source source = new DOMSource(target);
            Result dest = new StreamResult(System.out);
            tFormer.transform(source, dest);
        } catch (Exception e) {
            e.printStackTrace();

        }
		//streamBridge.send("output-out-0", MessageBuilder.withPayload(input)
        //        .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8)).build());
    }
	
}
