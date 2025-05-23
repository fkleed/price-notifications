db = db.getSiblingDB("price-notifications-db");

db.createUser({
    user: "application",
    pwd: "pw",
    roles: [
      {
        role: 'readWrite',
        db: 'price-notifications-db'
      },
    ],
  });

db.createCollection("price_notifications_collection");