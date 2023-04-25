create sequence if not exists attribute_id_seq start with 1 increment by 1;
create sequence if not exists business_id_seq start with 1 increment by 1;
create sequence if not exists hospital_id_seq start with 1 increment by 1;

create table if not exists attribute (
    id				smallint		primary key generated by default as identity,
    alias			varchar(64)		not null unique,
    name			varchar(64)		not null,
    description		varchar(255),
    created_at		timestamp		not null,
    updated_at		timestamp		not null,
    is_active		boolean			not null default false
);

create table if not exists business (
    id				bigint					primary key generated by default as identity,
    name			varchar(128)			not null,
    alias			varchar(128)			not null unique,
    rating			float					not null default 0,
    price			varchar(10)				not null,
    phone			varchar(32)				not null,
    is_active		boolean					not null default false,
    review_count	int						not null default 0,
    location 		geography(POINT, 4326)	not null,
    url				varchar(255),
    image_url		varchar(255),
    transactions	VARCHAR(128)			not null
);

create index if not exists business_location_idx
    on business
    using GIST (location);

create table if not exists public.business_attribute (
    business_id		bigint		REFERENCES business (id),
    attribute_id	smallint	REFERENCES attribute (id),
    CONSTRAINT business_attribute_pkey PRIMARY KEY (business_id, attribute_id)
);