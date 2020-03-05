# hydra config
export URLS_SELF_ISSUER=http://127.0.0.1:4444
export URLS_CONSENT=http://127.0.0.1:3000/consent
export URLS_LOGIN=http://127.0.0.1:3000/login
export URLS_LOGOUT=http://127.0.0.1:3000/logout
export DSN="mysql://root@tcp(127.0.0.1:3306)/hydra"
export SECRETS_SYSTEM=466ec702c61ebfdcd5ef7f960ba7d141
export OIDC_SUBJECT_IDENTIFIERS_SUPPORTED_TYPES=public,pairwise
export OIDC_SUBJECT_IDENTIFIERS_PAIRWISE_SALT=d9fff8b319549097235aa6622ab63ed3
export TTL_ACCESS_TOKEN=720h
export TTL_REFRESH_TOKEN=1080h

# start hydra ignore ssl (just for test)
hydra serve all --dangerous-force-http --dangerous-allow-insecure-redirect-urls=http://localhost:3333/callback