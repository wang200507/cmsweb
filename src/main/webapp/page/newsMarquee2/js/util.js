function prefixStyle (style) {
	var styleObj = document.createElement('div').style;
	var transformNames = { 
		webkit: 'webkitTransform',
		Moz: 'MozTransform',
		O: 'OTransform',
		ms: 'msTransform',
		standard: 'transform'
	};
	var getPrefix = function() { 
		for (var i in transformNames) { 
			if (styleObj[transformNames[i]] !== undefined) { 
				return i
			}
		}
		return false
	}();
	if (getPrefix === false) { 
		return
	}
	if (getPrefix === 'standard') { 
		return style
	}
	return getPrefix + style.charAt(0).toUpperCase() + style.substr(1)
}