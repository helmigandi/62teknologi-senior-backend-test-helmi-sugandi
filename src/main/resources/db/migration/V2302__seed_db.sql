INSERT INTO public.business
(id, "name", alias, rating, price, phone, is_active, review_count, "location", url, image_url, transactions)
values	(1, 'Molinari Delicatessen', 'molinari-delicatessen-san-francisco', 4.1, '$$', '+14154212337', true, 50, st_point(106.96659663520195, -6.210203076565325), 'http', 'http', 'PICKUP,DELIVERY,RESTAURANT_RESERVATION'),
          (2, 'RM Padang Jakarta', 'rm-padang-jakarta', 3.5, '$$', '+1415423241', true, 190, st_point(106.93904490004523, -6.220031292012974), 'http', 'http', 'DELIVERY,RESTAURANT_RESERVATION'),
          (3, 'RM Sederhana Bekasi', 'rm-sederhana-bekasi', 3.8, '$$', '+141547721', true, 350, st_point(106.97722212702158, -6.21110497043256), 'http', 'http', 'PICKUP,RESTAURANT_RESERVATION');

INSERT INTO public.attribute
(id, alias, "name", description, created_at, updated_at, is_active)
values 	(1, 'hot_and_new', 'Hot and New', 'popular businesses which recently joined Yelp', now(), now(), true),
          (2, 'request_a_quote', 'Request a Quote', 'businesses which actively reply to Request a Quote inquiries', now(), now(), true),
          (3, 'reservation', 'Reservation', 'businesses with Yelp Reservations bookings enabled on their profile page', now(), now(), true),
          (4,'waitlist_reservation', 'Waitlist Reservation', 'businesses with Yelp Wait List bookings enabled on their profile screen (iOS/Android)', now(), now(), true),
          (5, 'deals', 'Deals', 'businesses offering Yelp Deals on their profile page', now(), now(), true),
          (6, 'gender_neutral_restrooms', 'Gender Neutral Restrooms', 'businesses which provide gender neutral restrooms', now(), now(), true),
          (7, 'open_to_all', 'Open to All', 'businesses which are Open To All', now(), now(), true),
          (8, 'wheelchair_accessible', 'Wheelchair Accessible', 'businesses which are Wheelchair Accessible
Premium Access Tier attributes', now(), now(), true),
          (9, 'liked_by_vegetarians', 'Liked by Gevetarians', 'businesses which are liked by vegetarians', now(), now(), true),
          (10, 'outdoor_seating', 'Outdoor Seating', 'businesses with outdoor seating areas', now(), now(), true),
          (11, 'parking_garage', 'Parking Garage', 'businesses which itself has a garage or there is a parking garage nearby', now(), now(), true),
          (12, 'parking_lot', 'Parking Lot', 'businesses which have a parking lot', now(), now(), true),
          (13, 'parking_street', 'Parking Street', 'businesses with street parking available nearby', now(), now(), true),
          (14, 'parking_valet', 'Parking Valet', 'businesses which offer a valet parking', now(), now(), true),
          (15, 'parking_validated', 'Parking validated', 'businesses which can validate a parking ticket from an external parking', now(), now(), true),
          (16, 'parking_bike', 'Parking Bike', 'businesses with bike parking type', now(), now(), true),
          (17, 'restaurants_delivery', 'Restaurants Delivery', 'restaurants which offer delivery service', now(), now(), true),
          (18, 'restaurants_takeout', 'Restaurants Takeout', 'restaurants with take-out option', now(), now(), true),
          (19, 'wifi_free', 'Free WiFi', 'businesses with free WiFi', now(), now(), true),
          (20, 'wifi_paid', 'Paid WiFi', 'businesses with paid WiFi', now(), now(), true);

INSERT INTO public.business_attribute (business_id, attribute_id)
values	(1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7),
          (2, 8), (2, 9), (2, 10), (2, 15), (2, 16), (2, 17),
          (3, 1), (3, 9), (3, 11), (3, 12), (3, 19);

SELECT setval('business_id_seq', 3, true);
SELECT setval('attribute_id_seq', 20, true);
